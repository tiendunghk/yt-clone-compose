package com.d9.compose.yt.util

import com.d9.compose.yt.model.DrawerMenu
import com.d9.compose.yt.model.FilterAction
import com.d9.compose.yt.model.OtherSectionModel
import com.d9.compose.yt.model.RightOption
import com.d9.compose.yt.model.ShortFilter
import com.d9.compose.yt.model.ShortHomeModel
import com.d9.compose.yt.model.ShortModel
import com.d9.compose.yt.model.SubscriptionModel
import com.d9.compose.yt.model.TabFilter
import com.d9.compose.yt.model.YouOptionSection
import com.d9.compose.yt.model.YtVideoInfo
import com.d9.compose.yt.ui.theme.YoutubeIcons

object DummyData {
    val listShortHome = buildList {
        add(
            ShortHomeModel(
                image = YoutubeIcons.imgShort1,
            )
        )
        add(
            ShortHomeModel(
                image = YoutubeIcons.imgShort2,
            )
        )
        add(
            ShortHomeModel(
                image = YoutubeIcons.imgShort3,
            )
        )
        add(
            ShortHomeModel(
                image = YoutubeIcons.imgShort4,
            )
        )
    }
    val homeFilter =
        buildList {
            add(TabFilter(action = FilterAction.DRAWER))
            add(
                TabFilter(
                    label = "Tất cả",
                    selected = true,
                )
            )
            add(
                TabFilter(
                    label = "Đề xuất mới",
                )
            )
            add(
                TabFilter(
                    label = "Tin tức"
                )
            )
            add(
                TabFilter(
                    label = "Postcast",
                )
            )
            add(
                TabFilter(
                    label = "Danh sách kết hợp",
                )
            )
            add(
                TabFilter(
                    label = "Âm nhạc",
                )
            )
            add(
                TabFilter(
                    label = "Trò chơi"
                )
            )
            add(
                TabFilter(
                    label = "Trực tiếp"
                )
            )
            add(
                TabFilter(
                    label = "Hoạt hoạ"
                )
            )
            add(
                TabFilter(
                    label = "Bóng đá"
                )
            )
            add(
                TabFilter(
                    label = "Nấu ăn"
                )
            )
            add(
                TabFilter(
                    label = "Hoạt hoạ"
                )
            )
            add(
                TabFilter(
                    label = "Mới tải lên gần đây"
                )
            )
            add(
                TabFilter(
                    label = "Bài đăng"
                )
            )
            add(
                TabFilter(
                    label = "Gửi ý kiến phản hồi",
                    action = FilterAction.FEEDBACK,
                )
            )
        }

    val subscriptionsFilter =
        buildList {
            add(
                TabFilter(
                    label = "Tất cả",
                    selected = true,
                )
            )
            add(
                TabFilter(
                    label = "Hôm nay",
                )
            )
            add(
                TabFilter(
                    label = "Video"
                )
            )
            add(
                TabFilter(
                    label = "Shorts",
                )
            )
            add(
                TabFilter(
                    label = "Trực tiếp",
                )
            )
            add(
                TabFilter(
                    label = "Bài đăng",
                )
            )
            add(
                TabFilter(
                    label = "Tiếp tục xem"
                )
            )
            add(
                TabFilter(
                    label = "Chưa xem"
                )
            )
            add(
                TabFilter(
                    label = "Cài đặt",
                    action = FilterAction.FEEDBACK,
                )
            )
        }

    val listContinueWatching = buildList {
        add(
            YtVideoInfo(
                title = "How Notion Handles 200 BILLION Notes (Without Crashing)",
                channel = "Coding with Lewis",
                viewCount = "250K",
                time = "2 tuần trước",
                durationMs = "10:02",
                thumbUrl = "https://i3.ytimg.com/vi/NwZ26lxl8wU/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/kJV2KFYFDnp6pGtyaEepbBWtXak4MyojYxcF9sOVVzdWnzsMpkRUmV09inT1JD-qIxUUXmErFQ=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "7 Design Patterns EVERY Developer Should Know ",
                channel = "ForrestKnight",
                viewCount = "538K",
                time = "3 tháng trước",
                durationMs = "23:08",
                thumbUrl = "https://i3.ytimg.com/vi/BJatgOiiht4/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/TzjkRGVvMc1M9xCgoqMK8MOVxd6tLOhSdqnhx5AjVcWEgZGXtbZQY5Ji9Yj23aBc6GOANwjD=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "How I Code Apps SOLO That Actually Make Money (Idea + Build + Marketing Guide) ",
                channel = "Your Average Tech Bro",
                viewCount = "763K",
                time = "2 tháng trước",
                durationMs = "13:13",
                thumbUrl = "https://i3.ytimg.com/vi/dNntYdZQ_mk/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/5pF_FJYm1JPTCfZcv_9XdjGvIHjxa5SBr5H91T1U3xIRp872qFoDsnNgAIwREiTXU8Hamvfizi4=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "The Genius Behind Node.js Single Thread Model \uD83D\uDE80",
                channel = "ByteMonk",
                viewCount = "19K",
                time = "4 ngày trước",
                durationMs = "8:26",
                thumbUrl = "https://i3.ytimg.com/vi/os7KcmJvtN4/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/4Zw9XifSAyf1FNmM2969egek-4QjYpCT8ELGf3m4dP5YZiq6ch_MFjywuPjJt_hyWoTsO4U5Ug=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "You Were the Smart Kid. So Why Do You Feel So Lost Now?",
                channel = "Let's Talk Psychology Podcast",
                viewCount = "1.3M",
                time = "2 tuần trước",
                durationMs = "10:00",
                thumbUrl = "https://i3.ytimg.com/vi/U4PsIm9dDvs/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/YcOhysGCKXDuw9ZJYTywblg2OecDIn_FmAc3HLfBVJL5S_RlJ-f2HF1mb_MOfyRUUVUlfj-Q=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "The Secret to Speaking Fluent English",
                channel = "EngFluent",
                viewCount = "978K",
                time = "8 tháng trước",
                durationMs = "20:26",
                thumbUrl = "https://i3.ytimg.com/vi/9Pum3xDWnvI/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/ytc/AIdro_mEEsxoddDc3N6Ccqoxp6ZAgtGq6IDdqID9W5UQwH-VdlA=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "How to be confident (even if you’re not) | Montana von Fliss | TEDxBellevueWomen",
                channel = "TEDx Talks",
                viewCount = "382K",
                time = "4 tuần trước",
                durationMs = "16:07",
                thumbUrl = "https://i3.ytimg.com/vi/eVFzbxmKNUw/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/1gDPO-4YPWFErfn3yQBnv0yxpkmiud1m5CrorApkOqUYdNd9FrZQ9xB9C9VmDt4EsgArnlwqAQc=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "The Unstoppable Power of Letting Go | Jill Sherer Murray | TEDxWilmingtonWomen",
                channel = "TEDx Talks",
                viewCount = "6M",
                time = "8 năm trước",
                durationMs = "11:33",
                thumbUrl = "https://i3.ytimg.com/vi/nirKw3mWB3I/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/1gDPO-4YPWFErfn3yQBnv0yxpkmiud1m5CrorApkOqUYdNd9FrZQ9xB9C9VmDt4EsgArnlwqAQc=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "Timbaland - Apologize (lyrics) ft. OneRepublic",
                channel = "clouds 76",
                viewCount = "2.6M",
                time = "1 năm trước",
                durationMs = "16:50",
                thumbUrl = "https://i3.ytimg.com/vi/BuBqBgphDEE/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/cROL49dvwQW9X6dDOXlKCFU0WpVtHuoxNqGks1B6PuO0oqEzC9ci2bM-TvC6ymPPoKwchfi8s6s=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "Davichi & T-ara(다비치&티아라) _ We were in love(우리 사랑했잖아) MV ",
                channel = "1theK (원더케이)",
                viewCount = "104M",
                time = "13 năm trước",
                durationMs = "3:32",
                thumbUrl = "https://i3.ytimg.com/vi/nJ31sMmytHU/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/ytc/AIdro_mMIOmh4wMIoC6VrKI7X2GfDqKIMzi1e0mobnu6hqfN3QrD=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "Jumping Machine (跳楼机) (1.1x)",
                channel = "LBI - Topic",
                viewCount = "4.1M",
                time = "2 tháng trước",
                durationMs = "3:03",
                thumbUrl = "https://i3.ytimg.com/vi/mC1Ket54DW8/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/pwmJzlS4XlwSLiNXzZmfKern_skWcdkdniKnCapcbeVIiMmRKJuVkmTkIRR4PpnJvP9YrEQSQsk=s48-c-k-c0x00ffffff-no-rj",
            )
        )
        add(
            YtVideoInfo(
                title = "[Vietsub+Pinyin] Nơi đâu cũng thấy em - Đội trưởng | 《哪里都是你》- 队长 | \uD835\uDE44 \uD835\uDE6C\uD835\uDE56\uD835\uDE63\uD835\uDE69 \uD835\uDE6E\uD835\uDE64\uD835\uDE6A \uD835\uDE57\uD835\uDE56\uD835\uDE58\uD835\uDE60 ",
                channel = "Strange Loop Conference",
                viewCount = "16M",
                time = "3 năm trước",
                durationMs = "7:35",
                thumbUrl = "https://i3.ytimg.com/vi/6CLKldA4zDQ/maxresdefault.jpg",
                channelAvatarUrl = "https://yt3.ggpht.com/Vyshax_tX2M8qwDiA_chYVyeUTYQW_-Z13hisTn-a66sxGr1lOpwAYDFXj27HJVXRkuwfhFP=s48-c-k-c0x00ffffff-no-rj",
            )
        )
    }

    val listSubscriptions = buildList {
        add(
            SubscriptionModel(
                channel = "Dave Leeds",
                avatarUrl = "https://yt3.googleusercontent.com/6uv7e4faguga_0tgbwRyaRYISQC7kUYsrRr6bhFOAg08-L4cyqJrrvQMoUQWBA_inkR_htkI=s160-c-k-c0x00ffffff-no-rj"
            )
        )
        add(
            SubscriptionModel(
                channel = "Kotlin by JetBrains",
                avatarUrl = "https://yt3.googleusercontent.com/Dv5KK_wYBOzPMDKfufi-lyWOKsmKTIam0uulnK8R7QMDPPjO5IzcqGKn2Eo0DXKtukv1JRKLIlQ=s160-c-k-c0x00ffffff-no-rj",
                newUpdate = true
            )
        )
        add(
            SubscriptionModel(
                channel = "CM1X Official",
                avatarUrl = "https://yt3.googleusercontent.com/9lSfx0-z-eRAYbcvXInwXLmlwnB5UJ9RWtLZQYGaYwTaxfzJnFLy1KmrGJdDkiUPDlbjbIeF=s160-c-k-c0x00ffffff-no-rj"
            )
        )
        add(
            SubscriptionModel(
                channel = "Android Developers",
                avatarUrl = "https://yt3.googleusercontent.com/ND2tbbv3c3PKjaMn-pflO96159BeD6ImyuDoDSdXturz9XUeYkR3aqzYSwRjr7BYnhLQMyUNdQ=s160-c-k-c0x00ffffff-no-rj",
                newUpdate = true
            )
        )
        add(
            SubscriptionModel(
                channel = "Da LAB Official",
                avatarUrl = "https://yt3.googleusercontent.com/XvFuULyOHB8FEGgS6jW08wj6ZXHor5xsUwOkNf_khOVJOc_rbKnzfPny-g7vtjkceHguI2KHkQ=s160-c-k-c0x00ffffff-no-rj"
            )
        )
        add(
            SubscriptionModel(
                channel = "BẠN CÓ TÀI MÀ",
                avatarUrl = "https://yt3.googleusercontent.com/MpsGA52K_oyjutUf_FnfQZ9rr9345szlsuNk1il0gqGRtlVbX3mNTQQhH8btPjoWVDCDgjZlLA=s160-c-k-c0x00ffffff-no-rj"
            )
        )

        add(
            SubscriptionModel(
                channel = "Rhymastic Official",
                avatarUrl = "https://yt3.googleusercontent.com/Xrhjx95UhLd1ZMvdAbg_Oc-84MirqyY-hcxdcGFc-AGna5m42iv6N1GRYorKZN4nDSbSPlwt=s160-c-k-c0x00ffffff-no-rj"
            )
        )

        add(
            SubscriptionModel(
                channel = "VTV24",
                avatarUrl = "https://yt3.googleusercontent.com/WkRGl-uLsgZ8pwNxDnWTk6J1Xji1ZTOyyGia_dNapDkYnVDhlYu2X4Klc8hfdBY4CS15G7DPvFA=s160-c-k-c0x00ffffff-no-rj",
                newUpdate = true
            )
        )
    }

    val listYouOptions = buildList {
        add(
            YouOptionSection(
                icon = YoutubeIcons.icChangeAcc,
                label = "Chuyển đổi tài khoản"
            )
        )
        add(
            YouOptionSection(
                icon = YoutubeIcons.icGoogle,
                label = "Tài khoản Google"
            )
        )
        add(
            YouOptionSection(
                icon = YoutubeIcons.icIncognito,
                label = "Bật chế độ ẩn danh"
            )
        )
        add(
            YouOptionSection(
                icon = YoutubeIcons.icShare,
                label = "Chia sẻ kênh"
            )
        )
    }

    val listOtherSection = buildList {
        add(
            listOf(
                OtherSectionModel(
                    icon = YoutubeIcons.icVideo,
                    label = "Video của bạn",
                ),
                OtherSectionModel(
                    icon = YoutubeIcons.icDownload,
                    label = "Nội dung tải xuống",
                    note = "10 video mới"
                ),
                OtherSectionModel(
                    icon = YoutubeIcons.icBadge,
                    label = "Huy hiệu",
                )
            )
        )
        add(
            listOf(
                OtherSectionModel(
                    icon = YoutubeIcons.icFilm,
                    label = "Phim của bạn",
                ),
                OtherSectionModel(
                    icon = YoutubeIcons.icPremium,
                    label = "Lợi ích gói Premium",
                ),
            )
        )
        add(
            listOf(
                OtherSectionModel(
                    icon = YoutubeIcons.icStat,
                    label = "Thời lượng đã xem",
                ),
                OtherSectionModel(
                    icon = YoutubeIcons.icHelp,
                    label = "Trợ giúp và phản hồi",
                ),
            )
        )
    }

    val listShorts = listOf(
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
        ),
        ShortModel(
            shortVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4",
        )
    )

    val rightOptions = listOf(
        RightOption(
            icon = YoutubeIcons.icLike,
            label = "697 N"
        ),
        RightOption(
            icon = YoutubeIcons.icDislike,
            label = "Khôn...thích"
        ),
        RightOption(
            icon = YoutubeIcons.icComment,
            label = "4534"
        ),
        RightOption(
            icon = YoutubeIcons.icRepost,
            label = "8"
        ),
    )

    val shortFilters = listOf(
        ShortFilter(
            icon = YoutubeIcons.icSubChannel,
            label = "Kênh đăng ký"
        ),
        ShortFilter(
            icon = YoutubeIcons.icLiveStream,
            label = "Phát trực tiếp"
        ),
        ShortFilter(
            icon = YoutubeIcons.icShopping,
            label = "Mua sắm"
        )
    )

    val listDrawerMenu = listOf(
        listOf(
            DrawerMenu(
                icon = YoutubeIcons.icTrending,
                label = "Thịnh hành",
            ),
            DrawerMenu(
                icon = YoutubeIcons.icMusic,
                label = "Âm nhạc",
            ),
            DrawerMenu(
                icon = YoutubeIcons.icGame,
                label = "Trò chơi",
            ),
            DrawerMenu(
                icon = YoutubeIcons.icNews,
                label = "Tin tức",
            ),
            DrawerMenu(
                icon = YoutubeIcons.icSports,
                label = "Thể thao",
            )
        ),
        listOf(
            DrawerMenu(
                icon = YoutubeIcons.icYtStudio,
                label = "Youtube Studio",
                rawColor = true
            ),
            DrawerMenu(
                icon = YoutubeIcons.icYtMusic,
                label = "YouTube Music",
                rawColor = true
            ),
            DrawerMenu(
                icon = YoutubeIcons.icYtKids,
                label = "YouTube Kids",
                rawColor = true
            )
        )
    )
}