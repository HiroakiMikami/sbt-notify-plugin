# sbt-notify-plugin
sbtのtest結果などをnotify-sendを用いて通知するplugin.

## 使い方
* testを実行し, その結果を通知する場合には以下のようにする.
```sbt notify test```

## TODO
* 成功時, 失敗時のメッセージを編集可能とする.
    * Settingsを使えば簡単にできそう.
* Testの結果などを整形して表示するtest専用のnotifyを作る.
