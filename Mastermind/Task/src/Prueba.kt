
class Prueba{
    lateinit var lateInit: String

    fun anyThink(){
        println(this::lateInit.isInitialized) // false
        lateInit = "here set value"
        println(this::lateInit.isInitialized) // true
    }
}


fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    //s1.isEmptyOrNull1() eq true
    //s2.isEmptyOrNull1() eq true

    val s3 = "   "
    //s3.isEmptyOrNull1() eq false
    val valor = null
    val algo = valor ?: "no hay nada!"
    //println(algo)

    val value = arrayOf(1,2,3,4,5,6,7,1,3,2,4,5,6,43,2,2)
    val value2 = value.firstOrNull() { it > 8 }
    println("firstOrNull -> $value2")
    val value3 = value.count{ it > 1 }
    println("count -> $value3")
    println("joinToString -> ${value.joinToString ( " - " )}")
    println("contentToString -> ${value.contentToString()}")
    val value4 = value.partition { it > 4 }
    println("partition -> $value4")
    val value5 = value.groupBy { it == 1 }
    println("groupBy -> $value5")

//    val value6 = listOf(Person("nombre1", 10),
//        Person("nombre2", 20),
//        Person("nombre3", 20),
//        Person("nombre4", 30))

    println("associate -> ${listPerson().associate{ it.age to it.name } }")
    println("associateBy -> ${listPerson().associateBy{ it.name }}")

    //*** zip
    val listNumber = listOf(1,2,3,4,5)
    val q = listNumber.zip( listPerson())
    println("zip -> $q")

    //*** zipWithNext
    val list2 = listOf<Int>(1,2,3,4,5,6,7)
    val q2 = list2.zipWithNext()
    println("zipWithNext -> $q2")

    //*** map
    val qMap = listOf(
        "Fidel",
        "Villero"
    )
    //val map = qMap.map { it -> it + "***" }
    val map = qMap.map {  texto -> texto.toCharArray().map { it + "-" } }
    println("map -> ${map}")

    //*** flatMap
    val qFlatMap = qMap.flatMap { texto -> texto.toCharArray().map { it + "-" } }
    println("flatMap -> $qFlatMap")

    //*** flatten
    val listFlatten = listOf(listOf(1,2),
        listOf(3,4),
        listOf(5,6),
        listOf(7,8),
        listOf(9,10),
        listOf("11","12")
    )
    val qFlatt = listFlatten.flatten()
    println("Flatten -> $qFlatt")

    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.MALE))

    val d = heroes.all { it.age < 50 }
    println(" ejercicio All -> $d")

    val mapByAge: Map<Int, List<Hero>> =
        heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxBy { (_, group) ->
        group.size
    }!!
    println("ejercicio groupBy $age")

    val (first, second) = heroes
        //.flatMap { heroes.map { hero -> it to hero } }
        .flatMap { heroes.map { hero -> Pair(it, hero) } }
        .onEach { println("Filtrado: $it") }
        .maxBy { it.first.age - it.second.age }!!
    println("flatMap -> ${first.name}")

    val list1 = listOf(1, 2, 3)
    //val list1 = listOf(0, 1, 2)
    println("allNonZero -> ${list1.allNonZero()}")
    println("allNonZero1 -> ${list1.allNonZero1()}")
    println("allNonZero2 -> ${list1.allNonZero2()}")
    println("containsZero -> ${list1.containsZero()}")
    println("containsZero1 -> ${list1.containsZero1()}")
    println("containsZero2 -> ${list1.containsZero2()}")


    val lazyValue : String by lazy{
        "return value from lazy access"
    }


}

fun listPerson() : List<Person> {
    return listOf(Person("nombre1", 10),
        Person("nombre2", 20),
        Person("nombre3", 20),
        Person("nombre4", 30))
}

data class Person(val name: String, val age: Int)

data class Hero(val name: String, val age: Int, val genero: Gender?)
enum class Gender {FEMALE, MALE}

fun List<Int>.allNonZero() =  all {  it != 0 }
fun List<Int>.allNonZero1() =  none { it == 0 }
fun List<Int>.allNonZero2() =  !any { it == 0 }

fun List<Int>.containsZero() =  any { it == 0 }
fun List<Int>.containsZero1() =  !all { it != 0 }
fun List<Int>.containsZero2() =  !none { it == 0 }

//fun main(args: Array<String>) {
//    val list1 = listOf(1, 2, 3)
//    list1.allNonZero() == true
//    list1.allNonZero1() eq true
//    list1.allNonZero2() eq true
//
//    list1.containsZero() eq false
//    list1.containsZero1() eq false
//    list1.containsZero2() eq false
//
//    val list2 = listOf(0, 1, 2)
//    list2.allNonZero() eq false
//    list2.allNonZero1() eq false
//    list2.allNonZero2() eq false
//
//    list2.containsZero() eq true
//    list2.containsZero1() eq true
//    list2.containsZero2() eq true
//}

/*
#1 val f1: () -> Int? = null
#2 val f2: () -> Int? = { null }
#3 val f3: (() -> Int)? = null
#4 val f4: (() -> Int)? = { null }
 */