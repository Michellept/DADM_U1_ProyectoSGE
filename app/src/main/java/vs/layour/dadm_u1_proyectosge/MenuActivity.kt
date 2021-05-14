package vs.layour.dadm_u1_proyectosge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    lateinit var btnKardex : Button
    lateinit var btnHorario : Button
    lateinit var btnReticula : Button
    lateinit var btnDPersonales : Button
    lateinit var btnevaluacion : Button
    lateinit var btncerrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnDPersonales = findViewById(R.id.btn_datospersonales)
        btnHorario=findViewById(R.id.btn_horario)
        btnKardex=findViewById(R.id.btn_kardex)
        btnReticula=findViewById(R.id.btn_reticula)
        btnevaluacion=findViewById(R.id.btn_evaluacion)

        btncerrar=findViewById(R.id.btn_cerrar)


        var stringAlumno= intent.getStringExtra("ALUMNO")

        btnDPersonales.setOnClickListener {
            val intent= Intent(this, DpersonalesActivity::class.java )
            startActivity(intent)
        }

        btnHorario.setOnClickListener {
            val intent= Intent(this,HorarioActivity::class.java)
            startActivity(intent)
        }

        btnKardex.setOnClickListener {
            val intent= Intent(this, KardexActivity::class.java)
            intent.putExtra("ALUMNO", stringAlumno)
            startActivity(intent)
        }

        btnReticula.setOnClickListener {
            val intent = Intent(this, ReticulaActivity::class.java)
            startActivity(intent)
        }

        btnevaluacion.setOnClickListener {
            val intent = Intent(this, EvaluacionActivity::class.java)
            startActivity(intent)
        }


        btncerrar.setOnClickListener {
            intent.putExtra("ALUMNO", stringAlumno)
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }



    }
}