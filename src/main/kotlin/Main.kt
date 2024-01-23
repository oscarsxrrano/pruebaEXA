fun main() {
/*    // crida a la funció recursiva factorial, que calcula el factorial d'un número passat com a paràmetre
    println("El factorial de 4 és: ${factorial(4)}")

    // crida a la funció recursiva bucle, que fa un compte enrere fins a 0 des del número passat com a paràmetre
    println(bucle(10))

    // crida a la funció recursiva dobleFactorial, que un factorial doble del número passat com a paràmetre: 4!! = 4*4*3*3*2*2*1*1
    println("El factorial doble de 4 és: ${dobleFactorial(4)}")

    println(mostrarFactorial(4))

    println("Número de dígits del 12345: ${qDigitsNumero(12345)}")

    invertir(1234)

    println("Número 13 de la seqüència de Fibonacci ${fibonacci(13)}")

    println("El 123456 és creixent: ${nombresCreixents(123456)}")
    println("El 64 és creixent: ${nombresCreixents(64)}")

    println(numCreixents2(156))

    for(i in 2..50) {
        println("El número $i de la seqüència de Fibonacci és el ${fibonacci(i)}")//OJO QUE MUERE!!
    }
    for(i in 2..50) {
        println("El número $i de la seqüència de Fibonacci és el ${fibonacciNoRecursiva(i)}")
    }*/

    //println("La reducció del número 5699 és ${reduccioDigitsNoRecursiva(5699)}")
    //println("La reducció del número 5699 és ${reduccioDigitsRecursiva(5699)}")

    //INT
    val matrix: Array<Array<Int>> = Array(5) {
        Array(5) {
            (0..10).random()
        }
    }
    mostrarArray2D(matrix)
    println("La suma de tots els elements de la matrius és: ${sumaArray2D(matrix)}")
    println("La mitja dels elements de la matrius és: ${mitjaArray2D(matrix)}")
    println("La quantitat dels elements de la matrius iguals o superiors a 5: ${cincOMesArray2D(matrix)}")
    println("La mitja dels elements de la matrius iguals o superiors a 5: ${mitjaCincOMesArray2D(matrix)}")

    //CHAR
    val matric: Array<Array<Char>> = Array(5) {
        Array(5) {
            ('a'..'f').random()
        }
    }
    mostrarArray2D(matric)
    esborrarArray2D(matric)
    mostrarArray2D(matric)

}

fun mostrarArray2D(matriu:Array<Array<Int>>) {
    for(i in matriu.indices){
        for(j in matriu[i].indices){
            print("${matriu[i][j]} ")
        }
        println()
    }
}
fun mostrarArray2D(matriu:Array<Array<Char>>) {
    for(i in matriu.indices){
        for(j in matriu[i].indices){
            print("${matriu[i][j]} ")
        }
        println()
    }
}

fun sumaArray2D(matriu:Array<Array<Int>>):Int {
    var total=0
    for(i in matriu.indices){
        for(j in matriu[i].indices){
            total+=matriu[i][j]
        }
    }
    return total
}

fun mitjaArray2D(matriu:Array<Array<Int>>):Double {
    return sumaArray2D(matriu)/(numeroElementsArray2D(matriu)).toDouble()
}

fun numeroElementsArray2D(matriu: Array<Array<Int>>):Int {
    return matriu.size * matriu[0].size
}

fun cincOMesArray2D(matriu: Array<Array<Int>>):Int {
    var total=0
    for(i in matriu.indices){
        for(j in matriu[i].indices){
            if(matriu[i][j]>=5) total++
        }
    }
    return total
}
fun esborrarArray2D(matriu: Array<Array<Char>>) {
    for (i in matriu.indices) {
        for (j in matriu[i].indices) {
            matriu[i][j] = '_'
        }
    }
}

fun mitjaCincOMesArray2D(matriu: Array<Array<Int>>):Double {
    var total=0
    for(i in matriu.indices){
        for(j in matriu[i].indices){
            if(matriu[i][j]>=5) total+=matriu[i][j]
        }
    }
    return total/cincOMesArray2D(matriu).toDouble()
}

fun factorial(num:Int):Int {
    return if(num==1) 1
    else num*factorial(num-1)
}
fun bucle(num:Int):Int {
    if(num==0) return 0
    else {
        println(num)
        return bucle(num-1)
    }
}
fun dobleFactorial(num:Int):Int {
    return if(num==1) 1
    else num*num*dobleFactorial(num-1)
}
fun mostrarFactorial(num:Int):Int {
    if (num==1) {
        print("1 = ")
        return 1
    } else {
        print("$num X ")
        return num* mostrarFactorial(num-1)
    }
}
fun qDigitsNumero(num:Int):Int {
    return if(num/10==0) 1
    else 1+qDigitsNumero(num/10)
}
fun invertir(num:Int){
    if(num<10) print(num)
    else {
        print(num%10)
        invertir(num/10)
    }
}
fun fibonacci(num:Int):Int {
    return if(num==0) 0
    else if(num==1) 1
    else fibonacci(num-1) + fibonacci(num-2)
}
fun fibonacciNoRecursiva(num:Int):Int {
    if(num<=1) return num

    var numPrePre = 0
    var numPre = 1
    var numFib = 0
    for(i in 2..num){
        numFib=numPre+numPrePre
        numPrePre=numPre
        numPre=numFib
    }
    return numFib
}
fun nombresCreixents(num:Int):Boolean {
    val strNum = num.toString()

    if (strNum.length <= 1) return true //cas base

    if (strNum[0] > strNum[1]) return false

    return nombresCreixents(Integer.parseInt(strNum.substring(1)))  //tornem a cridar a la funció, traient el primer element
}
fun nombresCreixents2(num : Int ) : Boolean {
    if (num < 10){
        return true
    }else{
        var num1 = (num / 10) % 10
        var num2 = num % 10

        if (num1 <= num2){
            return nombresCreixents2(num / 10)
        }else{
            return false
        }
    }
}

fun reduccioDigitsNoRecursiva(num:Int):Int {
    var numero = num

    while(qDigitsNumero(numero)>1) {
        var numeroFinal = 0
        for (i in 1..qDigitsNumero(numero)) {
            numeroFinal += numero % 10
            numero /= 10
        }
        numero = numeroFinal
    }

    return numero
}

fun reduccioDigitsRecursiva(num:Int):Int {
    if(num<10) return num
    else return reduccioDigitsRecursiva(sumaDigits(num))
}

fun sumaDigits(num:Int):Int {
    if(num<10) return num
    else return (num%10) + reduccioDigitsRecursiva(num/10)
}
















