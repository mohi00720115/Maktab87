package com.example.tictoktoe

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.tictoktoe.ClassGame.turnCounter
import java.io.File
import java.io.FileOutputStream


@Suppress("DEPRECATION")        //ScreenShot
open class MainActivity : AppCompatActivity() {

    private lateinit var tv: TextView
    private lateinit var btnList: List<Button>


//    private val game = ClassGame()
    private val game = ClassGame
    private var statusA = true
    private var statusB = true

    val mainActivity2 = LoginActivity()

    lateinit var scoreList: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //region findViewByIds
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btnReset = findViewById<Button>(R.id.btn_reset)
        tv = findViewById(R.id.textView)
        val btnShare = findViewById<Button>(R.id.btn_share)
        //endregion

        btnList = listOf<Button>(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)

        //region ScreenShot
        val imageView = findViewById<ImageView>(R.id.imageView)
        val main = findViewById<View>(R.id.main)
        btnShare.setOnClickListener {
            val b: Bitmap = takeScreenshot(it.rootView)     //rootView -> activity_main.xml
            imageView.setImageBitmap(b)
            shareImageAndText(b)
        }
        //endregion  ScreenShot

//        scoreList = game.scoreLists


        val tvPlayers = intent?.getIntExtra("Player1", 1)
        game.turnCounter = tvPlayers!!
        tv.text = "Player$tvPlayers's turn"


        fun disables() {
            for (i in btnList) i.isClickable = false
        }

        fun playGame(selects: Int, btns: Button) {
            game.select = selects
            if (game.turnCounter % 2 == 1) btns.text = "X"
            if (game.turnCounter % 2 == 0) btns.text = "O"
            game.nextTurn(game.select)
            statusA = game.checkWin(game.player1)
            statusB = game.checkWin(game.player2)
            btns.isClickable = false
            if (statusA) {
                tv.text = Players.PLAYER2WIN.toString()
                disables()
            }
            if (statusB) {
                tv.text = Players.PLAYER1WIN.toString()
                disables()
            }
            if (!game.status && !statusA && !statusB) {
                tv.text = WinOrLose.DRAW.toString()
                disables()
            }

        }

        for (i in btnList) {
            i.setOnClickListener {
                playGame(btnList.indexOf(i) + 1, i)
            }
        }

        //RE-START
        fun disablesTrue() {
            for (i in btnList) i.isClickable = true
        }

        fun emptyString() {
            for (i in btnList) i.text = ""
        }
        btnReset.setOnClickListener {
            game.reset()
            disablesTrue()
            emptyString()
            tv.text = "Player$tvPlayers's turn"
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        btnList.forEach { btn ->
            val tg = btn.tag.toString()
            outState.putString("KEY_TEXT_$tg", btn.text.toString())
            outState.putBoolean("KEY_CLICK_$tg", btn.isClickable)
        }
        outState.putString("KEY_PLAYER", tv.text.toString())
        outState.putInt("KEY_COUNTER", game.turnCounter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tv.text = savedInstanceState.getString("KEY_PLAYER")
        game.turnCounter = savedInstanceState.getInt("KEY_COUNTER")
        btnList.forEach { btn ->
            val tg = btn.tag.toString()
            btn.text = savedInstanceState.getString("KEY_TEXT_$tg")
            btn.isClickable = savedInstanceState.getBoolean("KEY_CLICK_$tg")
        }
    }


/*

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Ac2 = onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Ac2 = onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Ac2 = onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Ac2 = onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Ac2 = onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Ac2 = onDestroy", Toast.LENGTH_SHORT).show()
    }

 */


    //ScreenShot

    fun takeScreenshot(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(
            view.width,
            view.height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }

    open fun convertImageToUri(bitmap: Bitmap): Uri? {
        val imageFolder = File(cacheDir, "images")
        var uri: Uri? = null
        try {
            imageFolder.mkdirs()
            val file = File(imageFolder, "shared_image.png")
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream)
            outputStream.flush()
            outputStream.close()
            uri = FileProvider.getUriForFile(this, "androidx.test.runner.AndroidJUnitRunner", file)
        } catch (e: Exception) {
            Toast.makeText(this, "" + e.message, Toast.LENGTH_LONG).show()
        }
        return uri
    }

    open fun shareImageAndText(bitmap: Bitmap) {
        val uri = convertImageToUri(bitmap)
        val intent = Intent(Intent.ACTION_SEND)

        // putting uri of image to be shared
        intent.putExtra(Intent.EXTRA_STREAM, uri)

        // adding text to share
        intent.putExtra(Intent.EXTRA_TEXT, "Sharing Image")

        // Add subject Here
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")

        // setting type to image
        intent.type = "image/png"

        // calling startactivity() to share
        startActivity(Intent.createChooser(intent, "Share Via"))
    }


}




