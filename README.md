# lazytool

lazy tool

加入你的库的依赖配置，例如：
在你项目的build.gradle文件中添加jitpack的仓库
allprojects {
repositories {
...
maven { url = uri("https://www.jitpack.io") }
}
}

然后在你要使用的模块中添加如下依赖：
implementation("com.github.Lazy-Ian:lazy-tool:1.0.0")

当前包含
标准的baseAdapter 抽象数据基类
BaseAdapter<T>(data: MutableList<T>)
带数据与ViewBinding 的抽象基类
BaseBindAdapter<T, V : ViewBinding>(data: MutableList<T>)

可以添加 头和尾的 adapter
abstract class HeaderFooterAdapter<T>(override var data: MutableList<T>) : BaseAdapter<T>(data)
控制头部显不显示 useHeader() 默认不显示

控制底部显不显示useFooter() 默认不显示
