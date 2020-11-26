package controllers.problems

import javax.inject.{Inject, Singleton}
import play.api.i18n.I18nSupport
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import services.problem18._

@Singleton
class Problem18Controller @Inject()(cc: ControllerComponents
                                    , calculator: Calculator)
  extends AbstractController(cc) with I18nSupport {

  val triangles = Seq[Triangle](
//    Triangle1
//    , Triangle2
  )

  def index(): Action[AnyContent] = Action { implicit request =>

    Ok(views.html.problems.problem18.index(
      triangles
    ))
  }

  def execute(): Action[AnyContent] = Action { implicit request =>

    Ok(views.html.problems.problem18.index(
      triangles
    ))
  }
}
