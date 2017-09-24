package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play._

case class Task(id: Long, label: String, body: String)

object Task {
  val task = {
    get[Long]("id") ~
      get[String]("label") ~
      get[String]("body") map {
        case id ~ label ~ body => Task(id, label, body)
      }
  }

  def all(): List[Task] = DB.withConnection { implicit c =>
    SQL("select * from task").as(task *)
  }
}
