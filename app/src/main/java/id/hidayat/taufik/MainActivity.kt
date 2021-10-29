package id.hidayat.taufik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.EditText
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Button
import java.text.NumberFormat
import java.text.DecimalFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var Jumlah: EditText? = null
    var Persen: TextView? = null
    var Persen2: SeekBar? = null
    var Pencairan: TextView? = null
    var Bunga: TextView? = null
    var Layanan: TextView? = null
    var Total: TextView? = null
    var Button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Jumlah = findViewById(R.id.jumlah)
        Persen = findViewById(R.id.persen)
        Persen2 = findViewById(R.id.persen2)
        Pencairan = findViewById(R.id.PencairanOut)
        Bunga = findViewById(R.id.bunga)
        Layanan = findViewById(R.id.LayananOut)
        Total = findViewById(R.id.total)

        Persen2!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, x: Int, b: Boolean) {
                Persen!!.text = "$x"
                Menghitung()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        Jumlah!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, x: Int, x1: Int, x2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, x: Int, x1: Int, x2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                Menghitung()
            }
        }
        )a
    }

    public fun Menghitung() {
        if (Jumlah!!.length() == 0) {
            Jumlah!!.requestFocus()
        }
        else
        {
            val jumlah = Jumlah!!.text.toString().toInt()
            val persen = Persen2!!.progress
            val bunga = jumlah * 3.75/100
            val layanan = jumlah * 5/100
            val pencairan = jumlah-layanan
            val total = jumlah+(bunga*persen)
            Bunga!!.text = bunga.toInt().toString()
            Layanan!!.text = layanan.toString()
            Pencairan!!.text = pencairan.toString()
            Total!!.text = total.toInt().toString()
        }
    }
}