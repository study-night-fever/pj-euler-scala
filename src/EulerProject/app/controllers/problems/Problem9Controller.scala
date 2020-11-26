package controllers.problems

import javax.inject.{Inject, Singleton}
import play.api.i18n.I18nSupport
import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import services.problem9._

@Singleton
class Problem9Controller @Inject()(cc: ControllerComponents
                                   , calculator: Calculator)
  extends AbstractController(cc) with I18nSupport {

  val inputForm: Form[Input] = Form(
    mapping {
      "sum" -> number
    }(Input.apply)(Input.unapply)
  )

  def index(): Action[AnyContent] = Action { implicit request =>
    val defaultValue = 1000

    Ok(views.html.problems.problem9.index(
      input = Input(defaultValue)
      , outputs = Seq.empty[Output]
    ))
  }

  def execute(): Action[AnyContent] = Action { implicit request =>
    inputForm.bindFromRequest().fold(
      hasErrors => {
        BadRequest(views.html.problems.problem9.index(
          input = hasErrors.get
          , outputs = Seq.empty[Output]
        ))
      },
      success => {
        Ok(views.html.problems.problem9.index(
          input = success
          , outputs = calculator.calculate(success.sum)
        ))
      }
    )
  }
}
