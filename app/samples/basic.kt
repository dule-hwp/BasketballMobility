fun sampleGetPointAtDistance() {
    val pathMeasure = PathMeasure()
    val currentDesiredPathEnd = PointF()
    val distanceCovered = 28f
    pathMeasure.getPointAtDistance(distanceCovered, currentDesiredPathEnd)
}

fun sampleToast() {
    toast("message")
}

fun sampleViewBind() {
    private val drillTitle by itemView.bindView<TextView>(R.id.list_item_drill_name)
    private val drillCount by itemView.bindView<TextView>(R.id.list_item_drill_performed_count)
    private val drillHighScore by itemView.bindView<TextView>(R.id.list_item_drill_high_score)
}

fun sampleActivityBind() {
    private val tvAngleDiff by bindView<TextView>(R.id.tvAngleDiff)
}
