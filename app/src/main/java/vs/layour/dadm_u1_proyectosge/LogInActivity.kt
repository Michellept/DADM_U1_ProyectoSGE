package vs.layour.dadm_u1_proyectosge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.json.JSONObject


class LogInActivity : AppCompatActivity() {

    lateinit var editNoControl: EditText
    lateinit var editpass: EditText
    lateinit var btnAcceder: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editNoControl = findViewById(R.id.editText_NControl)
        editpass = findViewById(R.id.editText_password)
        btnAcceder = findViewById(R.id.btniniciarsesion)

        val miJson = resources.getString(R.string.jsonDeAlumnos)
        val jsonAlumnos = JSONObject(miJson)
        val arrayAlumnos = jsonAlumnos.getJSONArray("alumnos")

        btnAcceder.setOnClickListener {
            val numcontrol = editNoControl.text.toString()
            val pass = editpass.text.toString()

            var acceso = false
            for (i in 0..(arrayAlumnos.length() - 1)) {
                print(arrayAlumnos[i].toString())

                val jsonEstudiante = arrayAlumnos.getJSONObject(i)
                if (jsonEstudiante.getString("noControl").trim().equals(numcontrol.trim())) {
                    acceso = true

                    if (jsonEstudiante.getString("contrasena").trim().equals(pass.trim())) {
                        Toast.makeText(this, "Encontrado", Toast.LENGTH_LONG).show()

                        val intent = Intent (this, MenuActivity::class.java)
                        intent.putExtra("ALUMNO", jsonEstudiante.toString())
                       //intent.putExtra("BD", miJson)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_LONG).show()
                    }
                }
            }
            if (!acceso){
                Toast.makeText(this,"No Existen estos datos",Toast.LENGTH_LONG).show()

            }
        }
    }


}
