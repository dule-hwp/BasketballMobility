[app](../../index.md) / [hwp.basketball.mobility.sensortilescan](../index.md) / [NodeArrayAdapter](.)

# NodeArrayAdapter

`class NodeArrayAdapter : `[`ArrayAdapter`](https://developer.android.com/reference/android/widget/ArrayAdapter.html)`<Node>, ManagerListener`

class that map a node into a view with the layout defined in node_view_item.
this class can be set as a [com.st.BlueSTSDK.Manager.ManagerListener](#) for automatically addDrillToDatabase
a node when it is discovered

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NodeArrayAdapter(mActivity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`)`<br>class that map a node into a view with the layout defined in node_view_item. this class can be set as a [com.st.BlueSTSDK.Manager.ManagerListener](#) for automatically addDrillToDatabase a node when it is discovered |

### Functions

| Name | Summary |
|---|---|
| [getView](get-view.md) | `fun getView(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, v: `[`View`](https://developer.android.com/reference/android/view/View.html)`?, parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`): `[`View`](https://developer.android.com/reference/android/view/View.html)<br>create a view that describe a particular node |
| [onDiscoveryChange](on-discovery-change.md) | `fun onDiscoveryChange(m: Manager, enabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>empty function |
| [onNodeDiscovered](on-node-discovered.md) | `fun onNodeDiscovered(m: Manager, node: Node): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>new node discovered -&gt; we addDrillToDatabase it to the adapter |
