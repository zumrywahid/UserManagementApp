package com.userapp.ui.signup

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
class SignupPresenter @Inject constructor(
        var userRepository: UserRepository,
        private val compositeDisposable: CompositeDisposable
) : SignupContract.Presenter {

    override fun validatePhoneNumber(phone: String): Boolean {
        return true
    }

    private var signupView: SignupContract.View? = null

    override fun takeView(view: SignupContract.View) {
        this.signupView = view
    }

    override fun dropView() {
        this.signupView = null
    }

    override fun signupUser(user: User) {

        this.signupView?.setLoadingIndicator()

        compositeDisposable.addAll(
                Observable.defer {
                    userRepository.insertUser(user)
                    Observable.just(1)
                }
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe ({ users ->
                            if (this.signupView == null) {
                                return@subscribe
                            }
                            this.signupView?.updateSignup(true)
                            this.signupView?.hideLoadingIndicator()
                        }, { throwable ->
                            if (this.signupView == null) {
                                return@subscribe
                            }
                            this.signupView?.hideLoadingIndicator()
                            this.signupView?.updateSignup(false)
                        })
        )



    }

    override fun validateEmail(email: String) {

        this.signupView?.setLoadingIndicator()
        compositeDisposable.addAll(
                Observable.defer {
                    Observable.just(userRepository.selectUserByEmail(email))
                }
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe ({ users ->

                            this.signupView?.hideLoadingIndicator()

                            if (this.signupView == null) {
                                return@subscribe
                            }

                            if (users != null && users.size > 0) {
                                signupView?.afterEmailValidation(false)
                            } else {
                                signupView?.afterEmailValidation(true)
                            }

                        }, { throwable ->

                            this.signupView?.hideLoadingIndicator()

                            if (this.signupView == null) {
                                return@subscribe
                            }

                            signupView?.afterEmailValidation(false)
                        })
        )
    }


}