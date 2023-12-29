# lazytool

lazy tool
引用
implementation("com.github.Lazy-Ian:lazy-tool:v1.0.0")

当前包含
标准的baseAdapter 抽象数据基类
BaseAdapter<T>(data: MutableList<T>)
带数据与ViewBinding 的抽象基类
BaseBindAdapter<T, V : ViewBinding>(data: MutableList<T>)

可以添加 头和尾的 adapter
abstract class HeaderFooterAdapter<T>(override var data: MutableList<T>) : BaseAdapter<T>(data)
控制头部显不显示 useHeader() 默认不显示

控制底部显不显示useFooter() 默认不显示
