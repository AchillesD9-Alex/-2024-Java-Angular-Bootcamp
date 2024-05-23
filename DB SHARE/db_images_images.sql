-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_images
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `image` longblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (1,'wassa',_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0	( \Z\Z%!1!%)+...383-7(-.+\n\n\n\r\Z\Z-% ------------------+----------7-----7-7-+--+7+++-++ÿÀ\0\0\Æ\0þ\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0C\0\0\0\0\0!1AQ\"aq2‘¡±BÁ#3RðTb‚“\Ñ\Ò\á$’ñ%4C¢\âÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0#\0\0\0\0\0\0\0\0\0!1AQ\"#Baÿ\Ú\0\0\0?\0™kn/\ÒË•S5¢üù\"×³+.\ncE	;d\\A»D¦\\Eßº†\â†tþvÿ\0%d`\Ð[dÆ©\íqµ¯º¤\åH\Ó%e/¸}Á!^p*k0§¢i*Q¬\r¬#³7Í™5H$\Ñ,vUr›\å}J¹´‡(\\q€X²¶L{xgƒ&¯¥N’\Ù<§\Ã\î\í¬—\ï\rô\ÙOQe-½–+£\é\Ñ?\ä*\àH\ì\Ö\Úû8\ï¦\Ãt|U\ãf”œŒc	q\ÜÎ‹T¸r9±ž1N|<•R·\è\Ý]\Ìôÿ\0tl_ˆKó63\á7ñspòòU\ç¹h±£H\ç’T\ZYI7&\ä¢›¦BLÕ³ªº¤C\ë¶/\É\Æ3¯\ÑpÖµKh¨\äM\ÛXÎ©A0\äTE†9§©s\r\ÚlÕ–‡l¶\Î\æ?PªE\èÍ“\ØõUi²S¢\ì\É\0`Vh\ë³®6?u$Ù¬¹œ«\Ó]o¨t\ä»\É?‰ …O-Êš¢m…\Öj]\á\î8Cv²;TtÕ¶&Ë´5eÄ‚´!&Õ°W¸me]{elªp\r\ÕA·.¤î±”[v±\Í/F\Ù-ªr\Éo\ËTvF N\á¡\ë¢\ÍÅ›¹¢\å‰6ñÛªVŽ”GŠB±ö`¹\Û[&X¸u€^¤¤¢\ÏA´JE(±¹Q®`\ÎM\ÒF¯K&ô\Õ.«—4\Ó5\Å\'\ÒÓ†³\Ãs\Ñ1Ä«l\\.Ÿ\Ð?3zh ±†\0MŽ«h:…ˆ«ŸGXE}´:¥±hó\ìšaT„€B”š+\Õ^§es(\ß\n\å<g>S²²6 `¢c\Ã\Ü]Ÿ\ÍH\ÕU\Ûs\È+d{\Å|\Ö\Ó\Ç],Ž³E\É>Ÿª\Ëq¼]\Õ9nÈ¯ \ën©\×q\ê^ZDm\'+oÿ\0\Øõ\ëeU¬¬¶Y\Ñ\"\Õu–¸j`e{¹”‹uN\Z\Û#™!b„¸\ÙXð\Ü¤k©H\à˜Q{…ÍWh\é\0h$\é_U¦(_YT@»…\Ú|’2p[ˆð‹«Ž‡¹\Þ\'›¢ºa1Ckf®…Š,£\È\Ñ\ç\ÜC’3«HöQ¦77ªôf=€2Qp\Ñe˜\ãœ2Ysm=\ÊxDr\ß\nu„n2 ’x¥fª=®²\Ä\Ò\Ú%œû[§/%+†\â¬\Ço\Èÿ\0šŠ¢\â\Å)\ËH#p³”vô\Ò2k\Â\Ü#¶ª^† Z\Å7¢-‘¡\í\×5¿\Ü\'\"’\×!eªEö“Ö¿SdJ‘ªJ¥š§øt7\ÝB}:.¢:ž[²\Çu3Hä¦ŸQ•`—¤\Ò\r‡ƒ{¢.\ëe…Ÿ	²y4wYI[/	]Ž\"úÛ¢ŒŽ@\0j­T\ä9 \ètþJc>n=Ö¹ Û²˜ò$©‘a\×ä—Ž[}\Ìhmü\Ò\ì¦\Ú)†;\ë+›%ñpöH/}”v!\ßrO¢·\Ç\ÉB\×a\î/\Ðiu|‘–¥p´ŸG#lßšp^3Yš\Ö\ê9&#+³1þ±\éYS|Jl+‹+ˆŠB94«_\âC\ÛnvP<K‡ÿ\0\ÒN6G-T\ìš\áh\ÒôÇ«&°\ßS’Š%<¨u\Ü|“G»)!xZ¤¨¡o\Äý“\Za²|{R~,:»at\ëei¤•\ï\Å\ãm~J»a.s££\ÍKð–**\"|/>0\ÝQn#ó]p\nH]ñ\ÍPö\Å!™CœFû\è.¦¨™n\ÈO•\Íù\'ü•‘Iq\â¹ç²‰\Åj\"q 4\ß]–ú\Ò3»tYX\ç°	sO+òòG­¢l¬\ÛuVÁq‡E\á½\Û\ÐôV\Ø*[l\ÍøO.l¬º¨«t\Ï1\ÞÍ˜\é²\Ëq\nD\â\×§¢¯\×B´küQ·^zy†L7\ÔZ2øa\í:§‘8!‰Ðº\'Ø‹&ñ9q´m[øJ²\Î1½\Ü\ß\Õ[AY•Icšðui~ª\ä1\'8\\sTh\ÙKƒªŠRM\Óúh\ì5PðV›\ï¢|\ìV1¹7òUüt]\ä±Ì•0	\ÛX:]—`7\çæ’“qù(Ô‹,2J\Ñ1~%cº­¾©\î<ý\Ñ‰\Ý\ß%\Z¥F»L\Ûñ¥gƒƒFýOúRl\í\ß÷^ÙúV\ÊH\çÕšsJ%;®óü\ì¨ö’\Ï\Í	\Þý2¥`\ío\Ýû¿ü«)\"5f=@f\ê\Z\\eÙ´\ÚöTÊ®:ŠCsp:]\"\Î,†÷ñ-\á8ý(\â\Í>..¡±\ÝùT}¢\Ó4[+‰þ|”V#\ÇQ¸\ÜF\á\ë\Ó\ä°\Í$\×\rqFŸKR\Ú[×‹«K)¥\×ò;\ê.n$q9\Ø\×kµPø\Î3$\Ì!Ù·“n›,\"¤¦\âA\Ý!.\étƒ÷Z£žC\ÊM‚°p\Õ#d™\r˜\Ñw]•zX)\æpešH\ÌE\í¦\ÝT§\Ò~œC7\âh‡…¢\Â\Ýv	T\êz†»\ÏPz)O$T‘	f9ž\á\à‡™‹ˆ\ØiõH\ÔLf\r•ñ6+\Û-\ï\ê,Žý \Ò0\ÉÀðH4õ*1´‚9$’R\\|N6\Z]RZ$&7nß‡\ÑZk\è€9Z\ë†¸f\0ó6+²/t`\Õ2-³Ð¿V\Ô\Äþ­\0k\ÝJa\ìaýÄ­wö	Kª\î\'…\ÑT’À!““\ã³O\ÐYÞ…Lp\ÇE\Ïø©À\è>\é\Õð:$®0sõ\×Óªjk\í3fþ|”¶%N\Öl÷nfö\å§ET\á\Ð\à\r\Úyò\n\í•Hg\Ç|8\Ùhe˜\0\r¤m\ÙÀ¬Yz;ˆfX9=ÎyÄ®Lñ¦kÁ\ÄEL\áòfn[>\Ê\"\ÑË•À®sX²q°®ny®\Zml\çd¦k‹ô\\d»\\{ª›PS\Ú\ÝQ¥\Î\Ñv\Þyò\æZr\ë»O-\ìp	²\\Ã¡ú{¤\Ý%œ,Pªˆ4‚6)h§ipB&¹	)£-6p7\\Teo£’\á\Ð|—l\ß\á š‡#™’,cg&·\ä¹\Z\Zl\Ñò	«®\Ü+ÀÏ«;\ålm?\ÞC¾¤r\æ¯¹q&¢­•,Œ°³G\È%eôZ`\ì\ÆX\Í+]Ìœ¤M™».€Ç•“\È¸q\Ëop\×ðK\é“\Ï(\Zr)ž1û£\ì~J\ÃÄ¼-SHlË³”Õ‡§§º®U›±Ãª£Mzi²k„\ZEÛ¥’2\rT£9z¶ý£\Ü\Ú\ä§šˆ§~¢ü”\á\0´½²#\ä‚Y_žCrw¹\ä9ú¦µ\ÎsEôm€\ì“îœ¸\Ø\í\êŽL(–~”‰ó_K-b•ù…÷¿ºÃ±¨ŒPS9¤Žñ’HN×´\Ï`Á­	ö-kb4¯p¬\æƒq˜uiõ]²k\é”Õ›N\Í\ËEú\Ø$&k˜<%Ã˜¬µ4™§ŒG+M¶wŸ•\ÒsN\àmk®Í¹h\Ã\ïFò\Ó:Sg>Þ‡\î¦pºB4\çõ)¢½œKI²›§¤\Úø‡#\çü”ª\ë$©v­X‡H/nðµƒ\ç²À\\´\î\Úñ|ó²™§\Ãs8m÷û6\ß5˜ÇžW#Xqc¬4¦wO\í;4‹\'pÚ-\åb:¥eaeNò\rÂ™†|\Íÿ\0Á\ÕS\ÓU!h\Ý\Õ2/êšµ\Ö$#‚–Hy\ÚZy$A\Ñ,]­\ÒrG\Í(‘(qGi\Zß¨ôJ2ž95‰\à\áv\ê0„>$\Ûög_¡\Ü\Ô\îiñ>\É,\ÉX1\'·G#|÷K†C/ÀüŽþh<\ìSTú‰Oö!õò\Züµû§T¸ƒ\Ø\îñ-v÷¦³\Ó:;æ¶º\ÜuH‡\ÙZ\r¢>\Zf\Ús\ÛfT·¼oñ‹\å±ZŽÁP/­\'›I‡«Wœ›5µ\é\çú£SW½„9ŽsH\æ	\èº#Ÿöc,)žž3ƒv¼hw¾­*‡\Æ}ž\Ó\È\Ç\ÍOû7†¸\äÿ\0\ãu‡MltU´\É\ã“Žõ»_ó??u9?h‘š	$I£OöCu$Ÿ+¯ø\æ¬\ËYÅ˜\ËEÎšÿ\0’o <ÕÅŒ²¾\\Œiq&\Ì­·F\ÔN¡ô\×\ì¹\\hØa²}KR[¯$£yü§\ßDfD\ætôº‚È°Q™]\Î\éœv¾j7*q\0°óUe‹vX\ÙiE,­k\\\ã?‰q\0ô\'[)Ž¦4\ä\Ð©øc¬\à\Û“ò´ik]tA\ÙI*Ež‡ð\Úã’–±Œs\Ýk\0I\'`5QÂ£\É~ð\ÛRnzj¢ø×‹\Øø,6m\àt¶\ÙAË§z]1\Òü\à|J\Ê\ê‰ lylc}õ%·-\Ó\Î\ÊñƒW·ð†W#kœ\ï\î\Þ\ë5\ì‡pòº\Þ±¿\è®N\îðº\Ã\Ë$ x•“q²g\Z}0\Üz¼\Ï,³;Ç¹ÀÀ$\å\Â\Ã\ÙD’NtM»4s´²j”‰ö*\Ý=‚\\¥1	\Üc@©#X’Eü\Â\ã^\ÚX£¸ª—y¢¹\Þi\è†E6Á÷\æL£yK\ç*I¸]=\äl‰Iknom‘.’FVEXb\äRPqI<è¥ /»›zì©˜ó7\é\Óä›‰I:$}Ï—\è¥pÍŽ©eiu\å¹oð\Þ\ÊF¢º;Z(ƒ^~\åC=»¨c˜\ÐI\ëËª¼Xº^y¾©!R	:zs)zh\âa¼€¿¨¬µ¹ÇºnQ\ç`~Š@Ý¢û\î-÷N\è\ãix9·v\àt\Ù4| Mý\Úæƒ\Ð|ÊŠ²S8Ê‰A½¾º)FqLñ·HÀ\å{“öQòXr\Åj\rö)\Õ\à}ôzüfzƒ•ò:Ç“Ihû§¬Á\Ü Ùº‘ýžg\ÙCw\0\Í6*ñb9¢kˆ\Ô;\ìn\Ãûº‘ÕŠ1ñxR¥ð\È\É\Z|6ö\Ù\Ì;\ÜyoUn\í\0wXEGžVú\æ}•:…\Â	nhd\Í\é‰£¥®Oû@\Çð	7}\'ø\Ø\ÝC½y1\æº\ÖWù8\îš1÷=“d¼\å\"¹f‚® ‚9\×R0¢Œ§O\â©g[{*I\ZDr\èE\à\ìAKz*š&\ÉF3UÜ©L½\nQ%u©PS`\â–c\Ç5fŠ!PWF\É\Î\è¤*’“pJˆ\å)‘G9\Z% óöMœˆ¯Vf\Øi[b¸\ÅË§\Ä9«;\\\í\0º|\ÉAq\Ëm:§•13}OE\Ùj\é\Ü|M\'\Óud‘$_x^| Ÿ//4¬p2ÿ\0´xoVƒ¯¿$ú¢¶Y\àt\0}\ïªa,\Ì:5Ÿ=Ï‘²‡I\æve\"0\Û|\ÝóHŸTÁ\ã  ô\å\ì¥\è\è³\0\ç_\ÐióóV»ð”ór°>\\Ô¦\Ã\Ò\È\ë÷e­\Þ\îý\0Ô¥\éckƒ@=T¥\'#6u\ÇC²\Ò0_\ìU’4|\í\É…’¦¢\Ï;ü$]Uiú9\Ý\Í!·³\ÚyNÚ­‹‡S@\Ùr†¸y./\è©|t\ÖOT\Ö\ØÀ	\ænIö#\æ´É‰%´F,®3½Á\Ì!†\à‹´ŽG‘QÒ,Odƒ•Ç‘²RŸ‡\\Ýž\àD‡hFŒ@\Æ=\ÎF\ç\í!Ö°²¬\ä\è\îüðj™@~\É$\á\ãD\ÝsO\Ð.…Ö¶\éV°!›²D¥‰\Ðú$”™+C†\Î)ºcøqG\ìT\Ä\ÖÊ¾BZòP^-\ØK£\Ùq\Ñ\Ù¡Ce‘\Ö¡\\hFUd…!„ªM\Ê\ÜE*ä›–¨\ÊGs. ¤©\ÒPq\ãrY‚\é¥Ú¡ 9Š[Zü¶SñÔ´\ÅY®Ps“¿x\ç\ës·Â«ðk¡	\ÍƒA¾»ùxÊ‹m\êœB\ni”\ï\Òw³\Æ\Ý\Å\î}é‚²²\á \á0ˆ)X6$S®¿5B \Õš\Ú9\Æ\×\è4K+?hx¸‚œ†û1¾ú=®¢¸N¦ \Ð./··U¦Zµò\ËVH4òT¾\Þ”\Ñ\ÛO¿+µiXD`G‘º\É{s­V² o\ÝFò.9¿U\\ª£H„\Þ\Ælç’Œ\Æ.±–G!p¶l\Z	]qD(HrtDh\Ñ\Ñ\â\ÖP=!(B)j’­G	4.”¡\ß~¿t\ÑqF¨\ØðN:£w\í\ë÷L‹JMQ;±á½~\é7J{!d\Õ»\ç$\×l…•ˆl	FóI\Ù\0ƒ®òE]²\â¡+\Ç4Š	\Zj–4ÜŸ¡Dš¡¤~\éŠ\í\Óþd\í6(À\Û8›\ëÈ«gñE{æ”´\Ú\Íð<ý‚\ÍWV‘\È\ã\á¥³¸ VMû;÷LøIj\ë”f˜œ3j\ÕB ¢Sr–\Ì.*F»OÚ„1E\àkœûh6fX¦$\é\å|²¹\æ\äý>É‚\âK#’¦BT\ì]²\Í\ãªA±s \\s‚Iq(X¿xðRV@¡b™‘K‘SB\Ã¸¸‚A{\à^(\Ã\â´XŽ\Ì\Ð	›{\ÖÜ\Þ€\àõ\ß\Õo”ü„½­s(©\Ü\×\0\æÛ‚\Ò.=^ImÝ…qÝ­‡T?Cÿ\0·s‹Eÿ\0ssbI&\íß§@€²QRPDØ©ð¸šf\nŒ€µŸ\Ø\Ñ\ÞX^\ç`t½“\Î\Èðú<Fþ#	…¦< N#\"9¬\ër\Î¹\r\Ð\\lµ&À¢®¦’š`r¼n7k‡\Âöù´\Øô\ÓT\Ê©°|>\Ã\Ã$\ë\â{µ$\êusœN—\ç`€Kþa_\Ô ÿ\0µc½³R6ŽAm<1<Ú†°½\Ï\ê\Ð\ç7+7\æ\Ä\ê­}’ö%\\òSV8w’9Ï€ø\Z\Ð4ý‡\"H\ÜnN«I\âN§®„\ÃSv99®™ŽÝ§q\èJ;ì«‡)kh[=^Kr\\\Zö¶\Æ@\×—9€Y¶ ¶\Ø(¾\Ñq,s\é\â\Ã`–¤›dý“3ki|\ÙH6˜\Ô+\ïñ,XELlf`\æ\ËpÜ­\Ós•±Û æ¼©S;ž\ç9\î.s‰sœMËœM\É\'©(§s\ç—\Ã\Ì÷\0\ÖDÀ\ÐI6kY·Sæ¥ \à\\I\â\í ©·œOB.µ¾\Ãñ…Ž2ösËª‹\Ûeñas‹tm…Ç‡’±qŒõ™\Ùÿ\0ª\Óa£/\î\Üc•Ï±7~iM­¥€¶› 09xh$\ÐT\Øt‰\Äü€º‚«¤’\'˜\åc£{~&=¥®\0‹´\ê4 û¯Zð\åô\î.\ÄYˆ#‡|\È\Û_vC	‹\Þý%Fþ‘ty\à¤,at†g1¶¼‚\Âr€5:€€Àé©Ÿ#š\È\Ø\ç½\Æ\ÍkAsœz5£RTô|‰¸(*luýÛùV«ý%†8*D±÷r¶O®am™”Ž”‹4´‡\Òy\Ýi˜\Ï\ÇV\æ\Èj*Xl;Š‡\Ä\Çs˜†8\ë¿D•\êø3ˆ]ô5 X›÷O ¹$\r*¼¦(›4´ò\Ç\È\r{\Ø\æµÄŒ\Ã)p\×Mn«c\áW\ÅdÕŒ9ƒ³I#j+‹LÓ¡kÛš£öÉ€W\ËAwIñÀ÷L\ç¥km”5ÿ\0œHË¶\È‡šgd†)%}‰\Ë÷Xnr´o5;ÿ\0ñO\êá•¸ö#UN\Ü.+1±?3ÄsK¯\ï8\0ý\Ú\Ý	¶\ÊÑŠp„s\Ê\é]SZ\Â\ëxcª–8Å€4\Ømó%\åšþ®„^Z:†k“ò‹›º\Ö6\é¶\'\ÔÓ†\ZŠybÍ“¼c˜]–Ù¬/¥\Ç\Íz¸pÜ±µŒ‚¾¥¤ß¼,¨.\æ\Î2´»~wò\Ñeý»`õ®†	¦0\Éš\é#k˜\âùH4D»+FV‹\æ7¿$/KI$\Æ\Ç=\îÙŒis=\Z5;;bnÂ‚¦Ç¬N\äE\Ö\Ù\Ù#7à£Ž+»kZ/3¤¶w[Y,.q&\ç˜\Zj—âŠŠ\ÎúòcT¸sm~\â\ÑJö·`\âç†¹Ù¬\r­¥\Èµ\Ð\\ü‰0]\Ô6ò‰\îú\0TÐ¹®-sK\\\ÒCšAk±A°ø9\åôq“V\Ú\Ã\ãÿ\0¨kZÁ%ž\á£ZH~7\Ëu–H\Ì89ônŽ2\é_Þ³\Âœ\æ³+€°\Þ\×q\Ùý°\Ê)\æŸñ²I\Ø\èƒõ‡0†bo“R\r¯\æ®ýµ`x|x{\æt²`Z\È^Æ†;¼$œ¾\\e6=/\Éb<ˆ\ÔS\Ö\Å-,o‘\í>&1†G:#`ñ• ŽþŠ\Ï\Ûf35US^i\ê\"§½\ÜFh¤;\â{\Ã^\ÑbmknD`ù\03TA\0A\0AY¸3¢¥“½«¥}Kš\æº6‰21¥¦÷pü\Ú\ÛC§ª¬ €\Þÿ\0\æ\ê2Š\ßô¨üw¶z:\ÈOQ‡H\èß¸\ïš#PZr\èA\æ±Dž\âŒ>\îšJ)*%\Ì\î\í\Î{-\ÖnR3\Ûw|¬´/ù€‡úŒŸ\â·ý+A«ñi8~$ÀÚŒ:\\\Íø$l\Í7¨¾MZzº\ÊJ\â\r“‚;ge-,T\Õ\Îwt\ÐÀø\Ü\Ñvv:\Ú\Ú\Â÷\Ö\×\æ‹\Å=£`µ\Îl•8uD²1¥­&A„\ÞÄ±û\\“±µ\Ö:‚fÁ;ml29¿€dt¾p–µ\Ñÿ\0v®¾ö¶\Û]Ôž%\Ûf!c\Ò>\'‡Çœ\Æ_b3\\\ØØžKA®pÿ\0l,„\Ö\Ë-.yje5ŒplM6\Æ\Z\ç’l\Ñrº\ìŒþ\Ö(¦ Ï†¾3qwSTº\'–\ëp\çF]¹9I²\ÈP@kñþ\×—67±¬}­¥\\\ã~\Ù\ÝU”\Ô\ÐwL‘®c\ß#ƒ\ÞX\àZZ\ZšH#[ž~«$A«pwjñP\á\Ñ\Òþ\ÓH\×HNg5±ùº8D»»P ”\ÞZ	\à\'6cITø<‰k\ÎÚ»e‘ €Ø°\Þ\Òp\Èdl­sšn•N{/\æ\Ó-¡\ÑCö‰Ú´˜Œ?†Ž$‚û¸=\ï--su°\r\0ƒµ\ï¢\ÍP@mü1Û”P\Ó\Ç\rE#\ïÀ\è\Ü\Ò•­m\Ë]l».Toö‚U\Ê*&\Â\æ’`\Z.\çˆ\Ú\àÓ¦p\Ç\Ù\Ý5\à²È@mXnM‹3$¡k!wL€µ½\Ó@-\Ê@\Ô\Ë\â·$ó\í®\ïŽaA+\æ‹?t^chax³ˆ Å†\Û]a( /\Ü\ÚK\èjj&|‘µ//‘­ð9®\Ì\ç~\Í\Æöo‰\Þ\å¯Y~=\í{ñôÎ¦Ž”F×‘™\ïp‘\ÖÑ\ÊN\Þ+õ\ÖT‚\0 ‚\0‚  € ‚\0 ‚\0‚  € ‚\0 ‚\0‚  € ‚\0 ‚\0‚  € ‚\0 ‚\0‚ ?ÿ\Ù');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-23 10:40:12
