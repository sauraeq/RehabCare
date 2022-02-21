package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Email_text=findViewById<EditText>(R.id.edit_text_email)
        val Password_Text=findViewById<EditText>(R.id.edit_text_password)
        val Sub_Button=findViewById<Button>(R.id.submit_res)

        Sub_Button.setOnClickListener()
        {



            val stringStringHashMap = HashMap<String, String>()
            stringStringHashMap.put("programme_code", Email_text.text.toString())
            stringStringHashMap.put("dob", Password_Text.text.toString())
            var signin: Call<LoginResponse> = APIUtils.getServiceAPI()!!.login(
                stringStringHashMap
            )
            signin.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>,


                ) {
                    Toast.makeText(this@MainActivity,response.body()!!.message,Toast.LENGTH_LONG).show()

                    try {

                        if (response.code() == 200) {
                            if (response.body()!!.success.equals("1")) {

                                startActivity(Intent(this@MainActivity, MainActivity::class.java))
                                finishAffinity()
                            } else {

                                Toast.makeText(this@MainActivity,response.body()!!.message,Toast.LENGTH_LONG).show()
                            }
                        } else {
                            Toast.makeText(this@MainActivity,response.body()!!.message,Toast.LENGTH_LONG).show()
                        }


                    } catch (e: Exception) {
                        Log.e("saurav", e.toString())
                    }

                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("Saurav", t.message.toString())

                }

            })





            val input_Email:String=Email_text.text.toString().trim()
            val input_Password:String=Password_Text.text.toString().trim()
            if(input_Email.isEmpty())
            {
              Email_text.error="plaese fill the value"
                Email_text.requestFocus()


            }
            if(input_Password.isEmpty())
            {
                Password_Text.error="Please fill the Value"

            }


            Toast.makeText(this,input_Email+input_Password,Toast.LENGTH_SHORT).show()
            intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("sa",input_Email)
            intent.putExtra("sau",input_Password)
            startActivity(intent)
            Email_text.text.clear()
            Password_Text.text.clear()



        }
    }
     fun login()
     {


     }

}