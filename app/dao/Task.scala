package dao

import scala.concurrent.Future

import javax.inject.Inject
import modeld.Task
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.jdbcProfile
