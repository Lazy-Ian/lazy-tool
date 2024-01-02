# lazytool

lazy tool

## 加入你的库的依赖配置，例如：

### Gradle

- Setp1: Add it in your root build.gradle at the end of repositories

        allprojects {
            repositories {
                ...
                maven { url = uri("https://www.jitpack.io") }
            }
        }


- Step2: Add the dependency

        dependencies {
            implementation 'com.github.Lazy-Ian:lazy-tool:1.0.0'
        }

## Usage

- ### 当前包含
 
      1.标准的baseAdapter 抽象数据基类
         BaseAdapter<T>(data: MutableList<T>) 
      2.带数据与ViewBinding 的抽象基类
         BaseBindAdapter<T, V : ViewBinding>(data: MutableList<T>)
      3.可以添加 头和尾的 adapter
         abstract class HeaderFooterAdapter<T>(override var data: MutableList<T>) : BaseAdapter<T>(data)
- #### 控制头部显不显示 
       useHeader() 默认不显示

- #### 控制底部显不显示
       useFooter() 默认不显示
