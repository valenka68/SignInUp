package com.example.valentinabulanova.signinup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import androidx.core.view.isVisible
import com.example.valentinabulanova.signinup.Constance
import com.example.valentinabulanova.signinup.databinding.ActivitySignUpBinding

class SignUpAct : AppCompatActivity() {
    lateinit var bindingClass: ActivitySignUpBinding
    private var signState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE)!!
        if(signState == Constance.SIGN_IN_STATE){

            bindingClass.edName.visibility = View.GONE
            bindingClass.edName2.visibility = View.GONE
            bindingClass.edName3.visibility = View.GONE
            bindingClass.bAvatar.visibility = View.INVISIBLE

        }

    }

    fun onClickDone(view: View){

        if(signState == Constance.SIGN_UP_STATE){

            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            intent.putExtra(Constance.NAME1, bindingClass.edName.text.toString())
            intent.putExtra(Constance.NAME2, bindingClass.edName2.text.toString())
            intent.putExtra(Constance.NAME3, bindingClass.edName3.text.toString())
            if(bindingClass.imAvatar.isVisible)intent.putExtra(Constance.AVATAR_ID, R.drawable.avatar)
            setResult(RESULT_OK, intent)
            finish()

        } else if(signState == Constance.SIGN_IN_STATE){

            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()

        }

    }

    fun onClickAvatar(view: View){

        bindingClass.imAvatar.visibility = View.VISIBLE

    }



}