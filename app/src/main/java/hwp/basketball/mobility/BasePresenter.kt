package hwp.basketball.mobility

/**
 * Each presenter interface should extend this interface.
 */
interface BasePresenter {
    /**
     * In this callback allocation of resources and initialization should happen.
     * */
    fun attach()

    /**
     * In this callback cleanup should happen.
     * */
    fun detach()
}