package gabriela.arevalo.areadetriangulo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val txtbase = findViewById<EditText>(R.id.txtbase)
        val txtaltura = findViewById<EditText>(R.id.txtaltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val lblResultado = findViewById<TextView>(R.id.lblResultado)

        val objCalc = Calcular()

        btnCalcular.setOnClickListener {
            val resul = objCalc.calcular(txtbase.text.toString().toDouble(), txtaltura.text.toString().toDouble())

            println("Este es el resultado: $resul")
            lblResultado.text = "El área es: $resul"
        }

    }
}