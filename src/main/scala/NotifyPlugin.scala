package hiroaki_mikami.notifyPlugin

import sbt._
import Keys._

object NotifyPlugin extends Plugin {
  // 成功時のコマンド
  val success = taskKey[Unit]("notify success")
  // 失敗時のコマンド
  val failure = taskKey[Unit]("notify failure")

  // コマンドの実行結果をnotifyするCommand
  lazy val notifyResult = Command.args("notify", "<command> <args>*") { (state, args) =>
    // コマンド文字列を作る.
    val command = args.foldLeft("")((str, line)=>s"${str}${line}")
    state.copy(remainingCommands = command +: "success" +: state.remainingCommands, onFailure = Some("failure"))
  }

  override lazy val settings = Seq(
    success := { "notify-send success".! },
    failure := { "notify-send failure".! },
    commands ++= Seq(
      notifyResult
    )
  )
}
