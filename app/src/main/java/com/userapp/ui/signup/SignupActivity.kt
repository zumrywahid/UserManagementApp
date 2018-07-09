package com.userapp.ui.signup

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.userapp.R
import com.userapp.data.User
import com.userapp.utilities.AlertUtil
import dagger.android.support.DaggerAppCompatActivity
import userapp.ui.home.DashboardActivity
import javax.inject.Inject

class SignupActivity : DaggerAppCompatActivity(), SignupContract.View {

    @Inject
    lateinit var presenter: SignupPresenter

    var fullnameField: EditText? = null
    var phoneField: EditText? = null
    var emailField: EditText? = null
    var passwordField: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        presenter.takeView(this)

        fullnameField = findViewById(R.id.fullnameField)
        phoneField = findViewById(R.id.phoneField)
        emailField = findViewById(R.id.emailField)
        passwordField = findViewById(R.id.passwordField)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    fun onSignup(view: View) {

        try {
            if (emailField?.text.toString().trim().isEmpty()) {
                AlertUtil.showAlert(this, "Warning", "Type your email")
                return
            }

            if (passwordField?.text.toString().trim().isEmpty()) {
                AlertUtil.showAlert(this, "Warning", "Password is empty")
                return
            }

            presenter.validateEmail(emailField?.text.toString().trim())
        }
        catch (e: Exception) {
           println(e.localizedMessage)
        }
        finally {
            // optional finally block
        }

    }

    override fun showMessage(message: String) {
        AlertUtil.showAlert(this@SignupActivity, "Message", message)
    }

    override fun showError(message: String) {
        AlertUtil.showAlert(this@SignupActivity, "Error", message)
    }

    override fun setLoadingIndicator() {
    }

    override fun hideLoadingIndicator() {
    }

    override fun updateSignup(isSuccess: Boolean) {
        if (isSuccess) {
            val intent = Intent(this@SignupActivity, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            AlertUtil.showAlert(this, "Warning", "Please try again")
        }
    }

    override fun afterEmailValidation(isSuccess: Boolean) {
        if (isSuccess) {
            var user = User(name = fullnameField?.text.toString(), email = emailField?.text.toString(), phone = phoneField?.text.toString(), password = passwordField?.text.toString())
            presenter.signupUser(user)
        } else {
            AlertUtil.showAlert(this, "Warning", "User with Email already exists")
        }
    }
}
