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
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.st.BlueSTSDK.Manager
import com.st.BlueSTSDK.Node
import hwp.basketball.mobility.R

/**
 * class that map a node into a view with the layout defined in node_view_item.
 * this class can be set as a [com.st.BlueSTSDK.Manager.ManagerListener] for automatically addDrillToDatabase
 * a node when it is discovered
 */


class NodeArrayAdapter(private val mActivity: Activity) : ArrayAdapter<Node>(mActivity, R.layout.node_view_item),
        Manager.ManagerListener {
    /**
     * image to show for the different boards
     */
    private val mNucleoImage: Drawable = ContextCompat.getDrawable(context, R.drawable.board_nucleo)
    private val mSTEVAL_WESU1_Image: Drawable = ContextCompat.getDrawable(context, R.drawable.board_steval_wesu1)
    private val mGenericImage: Drawable = ContextCompat.getDrawable(context, R.drawable.board_generic)

    /** empty function  */
    override fun onDiscoveryChange(m: Manager, enabled: Boolean) {}

    /**
     * new node discovered -> we addDrillToDatabase it to the adapter
     * @param m    manager that discover the node
     * *
     * @param node new node discovered
     */
    override fun onNodeDiscovered(m: Manager, node: Node) {
        mActivity.runOnUiThread {
            add(node)
        }//run
    }

    /**
     * disconnect al connected node manage by this adapter
     */
    internal fun disconnectAllNodes() {
        for (i in 0..count - 1) {
            val n = getItem(i)
            if (n != null && n.isConnected)
                n.disconnect()
        }//for
    }//disconnectAllNodes

    /**
     * create a view that describe a particular node
     *
     * @param position position that have to be build
     * *
     * @param v        where store the information
     * *
     * @param parent   group where the view will be stored
     * *
     * @return a view that contains the information about the node in position \code{position}
     */
    override fun getView(position: Int, v: View?, parent: ViewGroup): View {
        var v = v

        val viewHolder: ViewHolderItem

        if (v == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            v = inflater.inflate(R.layout.node_view_item, parent, false)
            viewHolder = ViewHolderItem()
            viewHolder.sensorName = v?.findViewById(R.id.nodeName) as TextView
            viewHolder.sensorTag = v.findViewById(R.id.nodeTag) as TextView
            viewHolder.boardType = v.findViewById(R.id.nodeBoard) as ImageView
            v.tag = viewHolder
        } else {
            //else -> is a recycled view -> we have only to update the values
            viewHolder = v.tag as ViewHolderItem
        }//if-else

        //get the corresponding sensor
        val sensor = getItem(position)

        viewHolder.sensorName?.text = sensor?.name
        viewHolder.sensorTag?.text = sensor.tag
        when (sensor.type) {

            Node.Type.STEVAL_WESU1 -> viewHolder.boardType?.setImageDrawable(mSTEVAL_WESU1_Image)
            Node.Type.NUCLEO -> viewHolder.boardType?.setImageDrawable(mNucleoImage)
//            Node.Type.GENERIC,
            else -> viewHolder.boardType?.setImageDrawable(mGenericImage)
        }//switch

        return v
    }//getView

    /**
     * class that contains view that we have to change between different items
     */
    private class ViewHolderItem {
        internal var sensorName: TextView? = null
        internal var sensorTag: TextView? = null
        internal var boardType: ImageView? = null
    }//ViewHolderItem

}// NodeArrayAdapter class
