[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step](../index.md) / [DrillSetupOutput](.)

# DrillSetupOutput

`object DrillSetupOutput`

Created by dusan_cvetkovic on 4/9/17.
This singleton instance will be used for each time we go through setup.

It should be used to pass data between setup and actual drill mode.

Make sure you call reset method before starting setup context.

### Types

| Name | Summary |
|---|---|
| [SensorConnectionData](-sensor-connection-data/index.md) | `data class SensorConnectionData` |

### Properties

| Name | Summary |
|---|---|
| [connectMap](connect-map.md) | `var connectMap: `[`HashMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-map/index.html)`<`[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`, `[`SensorConnectionData`](-sensor-connection-data/index.md)`>` |
| [drill](drill.md) | `var drill: `[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`?` |
| [players](players.md) | `val players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [reset](reset.md) | `fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
