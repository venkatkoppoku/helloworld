import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val f= Future {
  2/0
}
f onFailure {
  case npe:NullPointerException => println("i'd amazed if this printedout. ")
}


@volatile var totA = 0
val text = Future {
  "na" * 16 + "BATMAN"
}
text onSuccess {
  case txt => totA += txt.count(_ == 'a')
    println(s"totA: $totA")
}

text onSuccess {
  case txt => totA += txt.count(_ == 'A')
}