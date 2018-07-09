package com.userapp.ui.login

import com.userapp.data.User
import com.userapp.data.UserRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created on 7/7/18.
 */
class LoginPresenter @Inject constructor(
        var userRepository: UserRepository,
        private val compositeDisposable: CompositeDisposable
) : LoginContract.Presenter {

    private var loginView: LoginContract.View? = null

    override fun takeView(view: LoginContract.View) {
        this.loginView = view
    }

    override fun dropView() {
        this.loginView = null
    }

    override fun loginUser(email: String, password: String): Boolean {

        this.loginView?.setLoadingIndicator()
        compositeDisposable.addAll(
                Observable.defer {
                    Observable.just(userRepository.selectUserByEmail(email))
                }
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe ({ users ->
                            if (this.loginView == null) {
                                return@subscribe
                            }

                            if (users != null && users.size > 0) {

                                val user = users[0]

                                if (user.password.equals(password)) {
                                    loginView?.showLoginResult(true)
                                } else {
                                    loginView?.showLoginResult(false)
                                }
                            } else {
                                loginView?.showLoginResult(false)
                            }
                            this.loginView?.hideLoadingIndicator()
                        }, { throwable ->
                            if (this.loginView == null) {
                                return@subscribe
                            }
                            this.loginView?.hideLoadingIndicator()
                        })
        )

        return true
    }

}