fun main() {
    val num = 0
    println(bucle2(num))
}

/**
 * Función para calcular el precio total
 * Recoge los datos introducidos por el usuario anteriormente, y hace una operación para conseguir el precio del agua
 * @param num La quota fija a pagar
 * @return Int: La suma entre 'quotaVariable' y 'quotaFija'
 * @author oscarsxrrano
 * @since 2024-01-11
 */

fun bucle2 (num: Int): Int{
    return if (num>=10){
        num
    } else {
        println(num)
        bucle2 (num+1)
    }
}