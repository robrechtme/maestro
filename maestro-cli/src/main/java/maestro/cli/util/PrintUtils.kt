package maestro.cli.util

import org.fusesource.jansi.Ansi
import java.io.IOException
import kotlin.system.exitProcess

object PrintUtils {

    fun message(message: String) {
        println(Ansi.ansi().render("@|cyan \n$message |@"))
    }

    fun prompt(message: String): String {
        print(Ansi.ansi().render("\n@|yellow,bold $message\n> |@"))
        try {
            return readln().trim()
        } catch (e: IOException) {
            exitProcess(1)
        }
    }

    fun success(message: String, bold: Boolean = false) {
        println(
            Ansi.ansi()
                .render("\n")
                .fgBrightGreen()
                .bold(apply = bold)
                .render(message)
                .boldOff()
                .fgDefault()
        )
    }

    fun err(message: String, bold: Boolean = false) {
        println(
            Ansi.ansi()
                .render("\n")
                .fgRed()
                .bold(apply = bold)
                .render(message)
                .boldOff()
                .fgDefault()
        )
    }

    fun warn(message: String, bold: Boolean = false) {
        println(
            Ansi.ansi()
                .render("\n")
                .fgYellow()
                .bold(apply = bold)
                .render(message)
                .boldOff()
                .fgDefault()
        )
    }

    fun Ansi.bold(apply: Boolean = true): Ansi {
        return if (apply) {
            bold()
        } else {
            this
        }
    }

}