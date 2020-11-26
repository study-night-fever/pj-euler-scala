package controllers.problems

import javax.inject.{Inject, Singleton}
import play.api.i18n.I18nSupport
import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import services.problem1._

@Singleton
class Problem1Controller @Inject()(cc: ControllerComponents
                                   , calculator: Calculator)
  extends AbstractController(cc) with I18nSupport {

  val inputForm: Form[Input] = Form(
    mapping {
      "value" -> number
    }(Input.apply)(Input.unapply)
  )

  def index(): Action[AnyContent] = Action { implicit request =>
    val defaultValue = 10

    Ok(views.html.problems.problem1.index(
      input = Input(defaultValue)
      , output = NoOutput()
    ))
  }

  def execute(): Action[AnyContent] = Action { implicit request =>
    inputForm.bindFromRequest().fold(
      hasErrors => {
        BadRequest(views.html.problems.problem1.index(
          input = hasErrors.get
          , output = NoOutput()
        ))
      },
      success => {
        Ok(views.html.problems.problem1.index(
          input = success
          , output = calculator.calculate(success)
        ))
      }
    )
  }
}
