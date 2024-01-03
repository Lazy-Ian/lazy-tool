package com.lazyian.tool.util

import android.text.TextUtils
import android.text.format.DateFormat
import android.text.format.DateUtils
import android.text.format.Time
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Ian on 2021/5/18
 * Email: yixin0212@qq.com
 * Function :日期时间相关的工具类
 */
object DateTimeUtils {
    /**
     * 获得默认的 date pattern
     */
    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    private const val datePattern = "yyyy-MM-dd HH:mm:ss"

    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.SSS
     */
    private const val FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.SSS"

    /**
     * 英文简写（默认）如：2010-12-01
     */
    var FORMAT_SHORT = "yyyy-MM-dd"

    /**
     * 中文简写 如：2010年12月01日
     */
    var FORMAT_SHORT_CN = "yyyy年MM月dd"

    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    var FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒"

    /**
     * 精确到毫秒的完整中文时间
     */
    var FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒"

    /**
     * 根据预设格式返回当前日期
     *
     * @return
     */
    val now: String
        get() = format(Date())

    /**
     * 根据用户格式返回当前日期
     *
     * @param format
     * @return
     */
    fun getNow(format: String): String {
        return format(Date(), format)
    }
    /**
     * 使用用户格式格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */
    /**
     * 使用预设格式格式化日期
     *
     * @param date
     * @return
     */
    private fun format(date: Date?, pattern: String = datePattern): String {
        var returnValue = ""
        if (date != null) {
            val df = SimpleDateFormat(pattern, Locale.CHINA)
            returnValue = df.format(date)
        }
        return returnValue
    }
    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */
    /**
     * 使用预设格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @return
     */
    private fun parse(strDate: String, pattern: String = datePattern): Date? {
        val df = SimpleDateFormat(pattern, Locale.CHINA)
        return try {
            df.parse(strDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            null
        }
    }

    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return
     */
    fun addMonth(date: Date?, n: Int): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MONTH, n)
        return cal.time
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return
     */
    fun addDay(date: Date?, n: Int): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.DATE, n)
        return cal.time
    }

    /**
     * 获取时间戳
     */
    val timeString: String
        get() {
            val df = SimpleDateFormat(FORMAT_FULL, Locale.CHINA)
            val calendar = Calendar.getInstance()
            return df.format(calendar.time)
        }

    /**
     * 获取日期年份
     *
     * @param date 日期
     * @return
     */
    fun getYear(date: Date?): String {
        return format(date).substring(0, 4)
    }

    /**
     * 按默认格式的字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return
     */
    fun countDays(date: String): Int {
        val t = Calendar.getInstance().time.time
        val c = Calendar.getInstance()
        c.time = parse(date)
        val t1 = c.time.time
        return (t / 1000 - t1 / 1000).toInt() / 3600 / 24
    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return
     */
    fun countDays(date: String, format: String): Int {
        val t = Calendar.getInstance().time.time
        val c = Calendar.getInstance()
        c.time = parse(date, format)
        val t1 = c.time.time
        return (t / 1000 - t1 / 1000).toInt() / 3600 / 24
    }

    /**
     * 按用户给的时间戳获取预设格式的时间
     *
     * @param date    时间戳
     * @param pattern 预设时间格式
     * @return
     */
    fun getDate(date: String, pattern: String?): String {
        val dates = Date()
        dates.time = date.toLong()
        val format = SimpleDateFormat(pattern)
        return format.format(dates)
    }

    /**
     * 格式化时间 判断一个日期 是否为 今天、昨天
     *
     * @param time
     * @return
     */
    fun formatDateTime(time: String?): String {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
        if (time == null || "" == time) {
            return ""
        }
        var date: Date? = null
        try {
            date = format.parse(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val current = Calendar.getInstance()
        val today = Calendar.getInstance() //今天
        today[Calendar.YEAR] = current[Calendar.YEAR]
        today[Calendar.MONTH] = current[Calendar.MONTH]
        today[Calendar.DAY_OF_MONTH] = current[Calendar.DAY_OF_MONTH]
        //  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
        today[Calendar.HOUR_OF_DAY] = 0
        today[Calendar.MINUTE] = 0
        today[Calendar.SECOND] = 0
        val yesterday = Calendar.getInstance() //昨天
        yesterday[Calendar.YEAR] = current[Calendar.YEAR]
        yesterday[Calendar.MONTH] = current[Calendar.MONTH]
        yesterday[Calendar.DAY_OF_MONTH] = current[Calendar.DAY_OF_MONTH] - 1
        yesterday[Calendar.HOUR_OF_DAY] = 0
        yesterday[Calendar.MINUTE] = 0
        yesterday[Calendar.SECOND] = 0
        current.time = date
        return if (current.after(today)) {
            "今天 " + time.split(" ".toRegex()).toTypedArray()[1]
        } else if (current.before(today) && current.after(yesterday)) {
            "昨天 " + time.split(" ".toRegex()).toTypedArray()[1]
        } else {
            //            int index = time.indexOf("-")+1;
            //            return time.substring(index, time.length());
            val index = time.indexOf(" ")
            time.substring(0, index)
        }
    }

    /**
     * 将UTC-0时区时间字符串转换成用户时区时间的描述.
     *
     * @param strUtcTime UTC-0时区的时间
     * @param strInFmt   时间的输入格式
     * @param strOutFmt  时间的输出格式，若为null则输出格式与输入格式相同
     * @return 用户时区的时间描述.
     * @throws ParseException 时间转换异常
     */
    @Throws(ParseException::class)
    fun getUserZoneString(
        strUtcTime: String?,
        strInFmt: String?, strOutFmt: String?
    ): String {
        if (TextUtils.isEmpty(strUtcTime)) {
            throw NullPointerException("参数strDate不能为空")
        } else if (TextUtils.isEmpty(strInFmt)) {
            throw NullPointerException("参数strInFmt不能为空")
        }
        val lUserMillis = getUserZoneMillis(strUtcTime, strInFmt)
        var strFmt = strInFmt
        if (!TextUtils.isEmpty(strOutFmt)) {
            strFmt = strOutFmt
        }
        return format(lUserMillis, strFmt)
    }

    /**
     * 格式化时间.
     *
     * @param lMillis  时间参数
     * @param strInFmt 时间格式
     * @return 对应的时间字符串
     */
    fun format(lMillis: Long, strInFmt: String?): String {
        if (TextUtils.isEmpty(strInFmt)) {
            throw NullPointerException("参数strInFmt不能为空")
        }
        return DateFormat.format(strInFmt, lMillis) as String
    }

    /**
     * 将UTC-0时区时间字符串转换成用户时区时间距离1970-01-01的毫秒数.
     *
     * @param strUtcTime UTC-0时区的时间字符串
     * @param strInFmt   时间格式
     * @return 用户时区时间距离1970-01-01的毫秒数.
     * @throws ParseException 时间转换异常
     */
    @Throws(ParseException::class)
    fun getUserZoneMillis(
        strUtcTime: String?,
        strInFmt: String?
    ): Long {
        if (TextUtils.isEmpty(strUtcTime)) {
            throw NullPointerException("参数strUtcTime不能为空")
        } else if (TextUtils.isEmpty(strInFmt)) {
            throw NullPointerException("参数strInFmt不能为空")
        }
        val lUtcMillis = parseMillis(strUtcTime, strInFmt)
        val time = Time()
        time.setToNow()
        val lOffset = time.gmtoff * DateUtils.SECOND_IN_MILLIS
        return lUtcMillis + lOffset
    }

    /**
     * 转换时间格式，将字符串转换为距离1970-01-01的毫秒数.
     *
     * @param strDate  指定时间的字符串
     * @param strInFmt 时间字符串的格式
     * @return 指定时间字符串距离1970-01-01的毫秒数
     * @throws ParseException 时间转换异常
     */
    @Throws(ParseException::class)
    fun parseMillis(strDate: String?, strInFmt: String?): Long {
        if (TextUtils.isEmpty(strDate)) {
            throw NullPointerException("参数strDate不能为空")
        } else if (TextUtils.isEmpty(strInFmt)) {
            throw NullPointerException("参数strInFmt不能为空")
        }
        val sdf = SimpleDateFormat(
            strInFmt,
            Locale.getDefault()
        )
        val date = sdf.parse(strDate)
        return date.time
    }

    fun utc2BeiJingTime(message: String): String {
        var beiJingTime = message
        if (message.contains("#")) {
            val loginInfo = message.split("#".toRegex()).toTypedArray()
            if (loginInfo != null && loginInfo.size >= 3) {
                try {
                    val utcTime = loginInfo[1]
                    beiJingTime = getUserZoneString(utcTime, "HH:mm", null)
                    val repaceTimeStr = "#$utcTime#"
                    beiJingTime = message.replace(repaceTimeStr, beiJingTime)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
        }
        return beiJingTime
    }

    /**
     * @param duration 秒钟
     */
    fun format(duration: Int): String {
        var second = ""
        var minute = ""
        var time = ""
        //获取到时间
        val mm = duration / 60 //分
        val ss = duration % 60 //秒
        second = if (ss < 10) {
            "0$ss"
        } else {
            ss.toString()
        }
        minute = if (mm < 10) {
            "0$mm"
        } else {
            mm.toString() //分钟
        }
        time = "$minute:$second"
        return time
    }
}


