## Known Issues

### View not being identified

#### Symptom

The view context sensitive 'Down' does not display.

#### Problem

flash.display.DisplayObject does not resolve on Flex sdk 4.0.0 projects (for me anyway)

Joel Hooks pointed out that playerglobal doesn't import, heres the [Jira Bug](http://youtrack.jetbrains.net/issue/IDEA-51619)

Either import it manually or get the latest EAP.