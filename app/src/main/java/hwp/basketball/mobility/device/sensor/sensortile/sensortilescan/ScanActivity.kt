/*******************************************************************************
 * COPYRIGHT(c) 2015 STMicroelectronics

 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 3. Neither the name of STMicroelectronics nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 */
package hwp.basketball.mobility.sensortilescan

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.st.BlueSTSDK.Manager
import com.st.BlueSTSDK.Node
import com.st.BlueSTSDK.Utils.NodeScanActivity
import hwp.basketball.mobility.R
import kotlinx.android.synthetic.main.activity_scan.*

/**
 * This context will show a list of device that are supported by the sdk
 */
class ScanActivity : NodeScanActivity(), AdapterView.OnItemClickListener {

    /**
     * adapter that will build the gui for each discovered node
     */
    private lateinit var mAdapter: NodeArrayAdapter

    /**
     * addListener that will change button gui when the discover stop
     */
    private val mUpdateDiscoverGui = object : Manager.ManagerListener {

        /**
         * call the stopNodeDiscovery for update the gui state
         * @param m manager that start/stop the process
         * *
         * @param enabled true if a new discovery start, false otherwise
         */
        override fun onDiscoveryChange(m: Manager, enabled: Boolean) {
            if (!enabled)
                this@ScanActivity.runOnUiThread {
                    stopNodeDiscovery()
                }//run
        }//onDiscoveryChange

        override fun onNodeDiscovered(m: Manager, node: Node) {}//onNodeDiscovered
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        val myToolbar = findViewById(R.id.my_toolbar) as Toolbar
        setSupportActionBar(myToolbar)

        title = "Choose BLE device"
//        nodeListView = findViewById(R.id.nodeListView) as AbsListView
        //create the adapter and set it to the list view
        mAdapter = NodeArrayAdapter(this)
        nodeListView.adapter = mAdapter

        // Set OnItemClickListener so we can be notified on item clicks
        nodeListView.onItemClickListener = this

        //addDrillToDatabase the already discovered nodes
        mAdapter.addAll(mManager.nodes)

        refreshListVisibility()
    }

    private fun refreshListVisibility() {
        val isScanning = mManager != null && mManager.isDiscovering
        if (isScanning){
            nodeListView.visibility = View.GONE
            tvNoResults.visibility = View.GONE
            progressContainer.visibility = View.VISIBLE
            return
        }
        progressContainer.visibility = View.GONE
        if (mAdapter.isEmpty) {
            nodeListView.visibility = View.GONE
            tvNoResults.visibility = View.VISIBLE
        } else {
            nodeListView.visibility = View.VISIBLE
            tvNoResults.visibility = View.GONE
        }
    }

    /**
     * clear the adapter and the manager list of nodes
     */
    private fun resetNodeList() {
        mManager.resetDiscovery()
        mAdapter.clear()
        //some nodes can survive if they are bounded with the device
        mAdapter.addAll(mManager.nodes)
    }//resetNodeList

    /**
     * check that the bluetooth is enabled and register the lister to the manager
     */
    override fun onStart() {
        super.onStart()

        //addDrillToDatabase the addListener that will hide the progress indicator when the first device is discovered
        mManager.addListener(mUpdateDiscoverGui)
        //disconnect all the already discovered device
        mAdapter.disconnectAllNodes()
        //addDrillToDatabase as addListener for the new nodes
        mManager.addListener(mAdapter)
        resetNodeList()
        startNodeDiscovery()
    }//onStart

    /**
     * stop the discovery and delete all the lister that we attach to the manager
     */
    override fun onStop() {
        if (mManager.isDiscovering)
            mManager.stopDiscovery()
        //delete the addListener addDrillToDatabase by this class
        mManager.removeListener(mUpdateDiscoverGui)
        mManager.removeListener(mAdapter)
        super.onStop()
    }//onPause

    /**
     * build the menu, it show the start/stop button in function of the manager state (if it is
     * scanning or not )

     * @param menu menu where addDrillToDatabase the items
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scan, menu)

        val isScanning = mManager != null && mManager.isDiscovering
        menu.findItem(R.id.menu_stop_scan).isVisible = isScanning
        menu.findItem(R.id.menu_start_scan).isVisible = !isScanning

        return true
    }

    /**
     * called when the user select a menu item

     * @param item item selected, it will delete the discovered nodes and start a new scan or
     * *             stop the scanning
     * *
     * @return true if the item is handle by this method
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.menu_start_scan) {
            resetNodeList()
            startNodeDiscovery()
            return true
        }//else
        if (id == R.id.menu_stop_scan) {
            stopNodeDiscovery()
            return true
        }//else
        return super.onOptionsItemSelected(item)

    }//onOptionsItemSelected

    fun startNodeDiscovery() {
        super.startNodeDiscovery(SCAN_TIME_MS)
        invalidateOptionsMenu() //ask to redraw the menu for change the menu icon
        refreshListVisibility()
    }

    override fun stopNodeDiscovery() {
        super.stopNodeDiscovery()
        invalidateOptionsMenu()//ask to redraw the menu for change the menu icon
        refreshListVisibility()
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val n = mAdapter.getItem(position) ?: return

        val result = Intent()
        result.putExtra(NODE_TAG, n.tag)
        setResult(Activity.RESULT_OK, result)

        finish()
    }

    companion object {
        private val SCAN_TIME_MS = 10 * 1000 //10sec
        val REQUEST_SCAN = 100
        val NODE_TAG = "node_tag"
    }

}//ScanActivity
