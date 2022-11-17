package b2.uts2003040135.utsb2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edNilai1: EditText
    private lateinit var edNilai2: EditText
    private lateinit var edNilai3: EditText
    private lateinit var btHitung: Button
    private lateinit var tvIPK: TextView

    fun angka_huruf(angka: Double): String{
        var huruf = "E"
        if (angka>=86){
            huruf = "A"
        }else if (angka>=81){
            huruf = "A-"
        }else if (angka>=76){
            huruf = "B+"
        }else if (angka>=71){
            huruf = "B"
        }else if (angka>=66){
            huruf = "B-"
        }else if (angka>=61){
            huruf = "C+"
        }else if (angka>=56){
            huruf = "C"
        }else if (angka>=41){
            huruf = "D"
        }else if (angka<=41){
            huruf = "E"
        }
        return huruf
    }

    private fun huruf_poin(huruf: String): Double {
        var poin =0.0
        if (huruf.equals("A")){
            poin = 4.0
        }else if (huruf.equals("A-")){
            poin = 3.6
        }else if (huruf.equals("B+")){
            poin = 3.3
        }else if (huruf.equals("B")){
            poin = 3.0
        }else if (huruf.equals("B-")){
            poin = 2.6
        }else if (huruf.equals("C+")){
            poin = 2.3
        }else if (huruf.equals("C")){
            poin = 2.0
        }else if (huruf.equals("D")){
            poin = 1.0
        }else if (huruf.equals("E")){
            poin = 0.0
        }
        return  poin
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        edNilai1 = findViewById(R.id.edNilai1)
        edNilai2 = findViewById(R.id.edNilai2)
        edNilai3 = findViewById(R.id.edNilai3)
        btHitung = findViewById(R.id.btHitung)
        tvIPK = findViewById(R.id.tvIPK)

        btHitung.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        if (v?.id == R.id.btHitung){
            val inputNilai1 = edNilai1.text.toString().trim()
            val inputNilai2 = edNilai2.text.toString().trim()
            val inputNilai3 = edNilai3.text.toString().trim()

            val hurufNilai1 = angka_huruf(inputNilai1.toDouble())
            val hurufNilai2 = angka_huruf(inputNilai2.toDouble())
            val hurufNilai3 = angka_huruf(inputNilai3.toDouble())

            val poinNilai1 = huruf_poin(hurufNilai1)
            val poinNilai2 = huruf_poin(hurufNilai2)
            val poinNilai3 = huruf_poin(hurufNilai3)

            val jmlSKS = 3+3+3
            var ipk = ((poinNilai1*3)+(poinNilai2*3)+(poinNilai3*3))/jmlSKS
            ipk = String.format("%,2f",ipk).toDouble()

            tvIPK.text = "IPK : "+ipk
        }
    }
}