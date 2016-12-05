
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

def ultimateAnswer :Int = { 43 }

val f: Future[Int] = Future {

  ultimateAnswer
}
println("Continuing to run in parallel...")

f.onSuccess {
  case number =>
    println("The answer is " + number + ". Now, what was the question?")
}


val f1 :Future[Int] = Future {ultimateAnswer }
val f2:Future[Int]   = f1.map(_ + 1)
f2.onSuccess {
  case num =>
    println(s"number is : $num")
}

def longRunning(value:Int):Future[String]=
  Future {
    value.toString
  }

val f4:Future[Int] = Future { ultimateAnswer }





val f5:Future[Int] = f4.flatMap( value => Future(value + 1))



















