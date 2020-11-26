package controllers

import javax.inject._
import play.api.mvc._
import services.LinkItem

@Singleton
class HomeController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

  val links = Seq(
    LinkItem(services.problem1.Info, controllers.problems.routes.Problem1Controller.index())
    , LinkItem(services.problem2.Info, controllers.problems.routes.Problem2Controller.index())
    , LinkItem(services.problem9.Info, controllers.problems.routes.Problem9Controller.index())
  )

  def index: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.index(links))
  }
}
