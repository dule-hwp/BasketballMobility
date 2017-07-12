package hwp.basketball.mobility.entitiy.user

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by dusan_cvetkovic on 3/26/17.
 */
interface UserDataStore<T> {
    fun add(coach: T) : Completable
    fun findByEmail(email: String): Maybe<CoachViewModel>
}


