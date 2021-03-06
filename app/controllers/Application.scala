package controllers

import javax.inject._
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import models.Task


@Singleton
class ApplicationController @Inject() (label: String) extends Controller {
  val taskForm = Form(mapping(
                        "id"    -> ignored(0: Long),
                        "label" -> nonEmptyText,
                        "body"  -> nonEmptyText
                      ) (Task.apply)(Task.unapply))
  def tasks = Action {
    Ok(views.html.index(Task.all(), taskForm))
  }
}

