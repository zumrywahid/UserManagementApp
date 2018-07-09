package userapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.userapp.R
import com.userapp.ui.login.LoginContract
import com.userapp.ui.login.LoginPresenter
import com.userapp.ui.signup.SignupActivity
import com.userapp.utilities.AlertUtil

import dagger.android.support.DaggerAppCompatActivity
import userapp.ui.home.DashboardActivity
import javax.inject.Inject

/* 7/7/2018 : Zumry
* importing DaggerAppCompatActivity parent class will do the injection for us.
* */
class LoginActivity : DaggerAppCompatActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginPresenter

    var usernameField: EditText? = null
    var passwordField: EditText? = null
    var spinner: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        usernameField = findViewById(R.id.usernameField)
        passwordField = findViewById(R.id.passwordField)
        spinner = findViewById(R.id.progressBar1);

        val ab = supportActionBar

        if (ab != null) {
            ab.hide()
        }

        presenter.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    fun onSignup(view: View) {
        val intent = Intent(this@LoginActivity, SignupActivity::class.java)
        startActivity(intent)
    }

    override fun showMessage(message: String) {

    }

    override fun showError(message: String) {
    }


    override fun setLoadingIndicator() {
        spinner?.visibility = View.VISIBLE
    }

    override fun hideLoadingIndicator() {
        spinner?.visibility = View.GONE
    }

    override fun showLoginResult(isSuccess: Boolean) {
        if (isSuccess) {
            val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            AlertUtil.showAlert(this, "Warning", "Please try again")
        }
    }

    //TODO we should use android binding
    fun loginPressed(view: View) {

        if (usernameField?.text.toString().trim().isEmpty()) {
            AlertUtil.showAlert(this, "Warning", "Username is empty")
            return
        }

        if (passwordField?.text.toString().trim().isEmpty()) {
            AlertUtil.showAlert(this, "Warning", "Password is empty")
            return
        }

        presenter.loginUser(usernameField?.text.toString().trim(), passwordField?.text.toString().trim())
    }

}
