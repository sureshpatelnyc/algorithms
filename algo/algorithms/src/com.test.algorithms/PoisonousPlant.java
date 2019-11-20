package com.test.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PoisonousPlant {

	static int daysRequiredToDie(int[] a) {
		int lastMin = a[0];
		int lastIndex = 0;
		int index = 0;
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<a.length; i++) {
			int val = 0;
			if(a[i]> lastMin) {
				if(stack.isEmpty()) {
					stack.push(i-1);
					map.put(lastMin, 1);
				}
				if(a[i] < a[lastIndex] ) {
					if (stack.peek() != index && a[stack.peek()] <= a[i]){
					  //stack.pop();
					}else {
						stack.push(i);
					}
				}
				lastIndex = i;	
				
				
			}else {
				if(!stack.isEmpty()) {
					val = map.get(lastMin);
					if(val < stack.size()) {
						map.put(lastMin, stack.size());
					}
				}
				stack.clear();
				lastIndex = i;
				lastMin = a[i];
				index = i;

			}
			
		}
		
		if(!stack.isEmpty()) {
			int val = map.get(lastMin);
			if(val < stack.size()) {
				map.put(lastMin, stack.size());
			}
		}
		
		int days = 0;
		for(Integer val: map.values()) {
			if(val > days) {
				days = val;
			}
		}
		return days;
	}
	public static void main(String[] args) {
		//int a[] = {2,11,5,14,5,10,9,19,12,5};
		//int a[] = {6, 5, 8, 4, 7, 10, 9};
		int a[] = {6,12,12,8,8,7,1,10,15,5,12};
		//int a[] = {19742,1295,5338,4127,15418,4285,5806,13711,1967,7035,18528,6053,9883,12259,17246,6873,3108,12284,15013,8837,14043,89,6286,12048,18585,1036,9267,13799,5453,4473,13260,16853,6316,4105,16716,10520,17352,6648,2120,1490,18003,2569,8405,162,1913,2124,14414,8717,13486,12929,6226,2213,1533,13230,4176,10232,18038,9544,4674,14150,7227,16420,18501,6131,6301,8690,14895,10166,8589,16434,11412,17295,4156,5503,6612,15724,8157,16667,1711,8611,15335,11154,6121,8999,10844,14812,19088,16364,2367,147,6137,1330,7695,14451,326,12329,19665,8736,7098,6977,12270,11054,9492,15682,16177,1508,13538,18146,19908,13261,568,4881,3564,2304,8907,3321,16167,16783,1463,8101,6644,5811,16075,13836,15807,253,10671,11098,14333,17918,7783,4545,1333,9833,3396,13036,19687,1202,19911,13006,13884,17072,3412,5207,11169,1536,1829,3878,13920,11730,12360,7427,13752,2493,1680,9683,15733,11024,17353,6556,5297,16821,15245,15857,1548,12954,19398,9039,9358,4736,5312,11269,8169,7337,19063,15,14600,9699,18809,7333,7621,3035,3647,15969,14292,4582,14572,19283,18110,8380,5845,2602,19599,19296,3032,8108,26,6706,10984,5828,10728,403,6466,12491,2728,8108,16418,1437,12980,5039,12334,15094,9789,1862,16898,7461,3125,10910,13156,1048,15780,14489,15889,18627,13629,13706,16849,13202,10192,17323,4904,6951,16954,5568,4185,7929,8860,14945,3764,4972,13476,14330,1174,18952,10087,10863,9543,12802,1607,9354,13127,920,17113,5312,11295,4999,14502,15896,1897,13776,1017,7913,4616,11096,12042,324,16626,15381,14168,15926,1591,4804,15560,19276,469,8638,749,14148,11177,1429,4409,18664,15703,6365,551,2001,3245,7949,5021,15646,1258,4324,16125,17913,14103,13721,7212,14716,16873,16620,6153,2871,4053,5343,17024,19516,7467,7283,11775,8740,16186,15934,8434,18359,3144,16682,18978,6412,19666,15385,19549,1624,10319,2354,16058,5671,994,6283,18146,1427,13735,4176,11469,12004,13756,17019,18438,12399,3105,1680,4395,15948,1439,260,15486,9941,1584,19494,3366,4095,18765,4468,17294,15391,4641,16655,5819,4583,12262,3110,18006,8626,2553,15424,17310,12223,9540,17623,10557,7090,7857,18331,13644,13948,7839,19373,12895,10187,10195,18741,14835,8930,5782,8632,3658,3382,9472,12869,5743,16197,16283,4577,15835,14337,13890,2332,12641,4953,3347,6056,15387,9377,12387,4396,13641,10557,2832,4186,12076,426,18453,1068,741,7050,12111,12866,6139,9816,16483,17023,6222,4212,468,2518,17822,10112,12227,17744,207,6822,6640,14512,4040,2096,15873,98,56,7209,18206,2148,5866,7816,7539,8740,6823,10482,19277,9110,19342,14760,930,18545,11529,10282,11456,7443,964,6314,13768,6392,13031,8177,10696,15019,779,8474,3664,4127,1786,16367,1627,3731,15233,5319,18736,14885,8838,1340,5570,16976,3385,17133,3777,15979,19591,2046,2797,19091,6864,13522,2808,590,4564,15588,9362,18848,1623,2038,12532,19352,19497,4721,6809,6288,17022,11583,1785,7024,8110,150,5922,18219,14284,2133,19200,3086,8195,18434,19493,17477,7859,8071,11051,16785,9811,16273,13357,3591,18882,9374,9705,18474,7883,281,19233,10208,7981,16513,17499,10924,2507,4020,8826,8347,10840,10727,12346,27,11312,4337,17554,19257,12225,988,14041,12121,1360,745,9119,11761,17379,11398,2389,6791,9818,1225,1287,19122,1683,16027,3574,7947,9168,2250,3187,7756,19943,6327,15435,3337,18968,18646,4703,9170,7280,15588,15024,6021,19332,14874,3842,16894,12759,18301,13487,1762,1359,14803,18771,871,4095,13975,18087,13321,18328,12453,16575,4124,15354,9568,13159,6329,4454,8915,301,12856,10070,8088,148,10868,12418,17499,10430,11694,12702,2287,16547,6816,14463,6056,9940,19162,1956,2655,10540,2067,19226,9491,10592,1401,3691,4532,7604,10431,6197,6092,15654,10159,11496,2763,5275,9039,3741,11304,14780,4085,6899,17441,1738,14955,782,16777,7733,11456,18177,1026,7392,17910,17689,16933,11855,5443,6006,19232,4662,1985,15088,8679,15841,7526,5411,9202,4613,14493,3516,11390,19160,15755,13044,623,8311,19786,8904,1388,13436,10250,2805,7858,14915,12059,9476,8670,10784,12548,19768,695,792,4157,13869,1842,5204,16511,7534,1588,7078,19370,4474,940,15614,8922,14632,15438,12718,4982,700,16592,3660,14081,2699,15208,8395,9376,1175,15998,9246,2108,11785,5699,3792,3101,14915,8805,2965,14541,10109,10744,11767,11869,6145,18787,2135,7997,14664,14226,8075,4054,6535,15641,18897,15859,6051,11421,19854,18352,2245,18352,12387,15301,7222,18691,14829,4292,4494,8963,12982,9164,822,13132,9868,14721,17076,15586,5449,3360,7490,6535,12261,9752,10234,3031,4691,17723,12925,12122,17883,13600,13366,17820,11087,14324,15973,9911,9414,17963,16520,14331,3226,379,2488,5610,3283,18775,4652,2491,12598,12640,2807,16954,19560,5987,8397,16823,9053,1631,10242,3344,3813,11803,15213,3634,8258,4966,16904,15240,9284,3368,13254,2969,4835,4769,906,8823,10127,11732,9038,6217,15207,4033,15872,14733,9311,19109,15583,17541,1304,12488,2480,14440,9117,11603,18343,1482,18609,9064,8915,11430,14436,5017,18436,17072,18685,10786,4541,6816,19631,6664,17115,12692,1470,1098,18500,4918,1022,14923,7488,3585,16212,19624,979,1261,15272,7416,17467,8479,12120,13417,6252,18720,6297,7601,13585,10142,542,6742,697,7355,13024,12283,5428,1871,18536,3801,6141,9385,11067,9211,2061,7403,6423,7234,14224,6284,10711,14606,6419,16896,7629,7038,6890,587,10446,19924,9675,14039,13072,9380,1520,9561,4758,19312,14628,6387,3634,5534,1327,15910,16137,13025,3563,19106,14285,4663,17696,5430,7323,17594,5460,14287,6688,7764,3560,16601,5766,8119,2548,10087,18652,7675,16914,2209,19168,1594,19657,7672,7308,9542,6456,6337,16506,19703,16645,16724,18421,16754,9702,11594,4959,19290,13275,15677,4078,1075,9510,13560,16239,12497,12186,15367,5253,1374,10866,9374,16484,2560,11433,3692,3277,13942,16132,9976,16172,11431,3417,2261,7681,8549,4831,114,15250,1367,18238,19350,5170,10491,18875,7137,15638,14672,4872,8656,17433,17003,19459,3959,2391,10983,19656,5150,11070,4195,11117,9109,14495,5258,1602,11723,4670,19134,11170,11320,1038,5901,15911,14935,16826,6829,1730,5000,13637,946,10427,16288,5083,13742,11454,9430,17736,7130,6441,3392,17293,17830,11290,11689,6656,660,6156,11428,7943,19144,15879,15291,19659,4037,10832,15635,8676,11837,13476,8114,3318,13151,10693,1979,9916,15129,14495,4270,19777,5966,10131,14249,7432,9397,16945,17924,5533,4517,5351,18565,19181,9200,6250,6344,198,4,3083,17008,11623,14362,6939,19414,740,1485,8709,2030,2370,1717,8170,12937,5356,1895,523,18483,8746,16105,17401,10455,6737,2036,1261,11947,611,3157,17315,18314,4908,15191,11597,3650,2415,8329,2388,5458,5362,8695,6670,8279,19687,11940,241,1218,8263,6870,4943,1287,8678,16357,18502,17071,11315,5478,10887,5281,18011,17702,2929,5898,10888,8673,3166,2019,5699,6238,19108,1774,458,16079,14030,11949,11611,3450,6356,381,17691,18480,12711,4768,7378,1976,10183,14557,14379,5288,18598,3837,6168,11813,12650,16805,17877,19353,12778,8552,19185,18607,11865,12781,8968,7051,6507,11648,19381,4997,9263,8661,4428,13450,7014,16387,13325,3043,5510,13572,8251,18454,12903,12019,19040,13087,3630,6368,13071,13116,2538,17332,11200,3027,15039,12340,7089,8550,13577,1446,19051,18177,5147,12490,2813,10250,2575,4733,12041,19486,5521,14428,3326,13670,16206,5689,481,3423,15799,2385,10493,12320,7233,6456,5777,13976,12342,8883,8212,5685,14846,8913,13279,9069,10366,4786,8645,8321,16036,5883,18342,5788,14530,19937,4824,16657,6613,12295,12682,5381,15178,15358,6639,1058,6425,12303,13994,2868,2008,10436,11614,19859,18815,16031,1284,14061,6875,16983,16789,7097,15596,9459,12961,759,4466,15313,17258,15595,14142,17055,15957,10722,13583,5613,8960,11801,4896,11367,5520,14755,12050,4825,2264,16578,16360,7722,3035,8590,17286,3489,8736,4206,5493,7030,2002,4917,19758,13542,16700,1460,7436,4877,7081,4413,13832,11224,10126,17192,5392,3294,13270,11317,7718,14998,5561,9439,238,13614,3307,7782,14826,9712,18600,16840,14624,16697,9705,14314,19427,10432,9173,448,12866,19785,830,11542,18004,10692,15247,2904,8618,10531,11952,3209,18618,2863,4310,16914,11261,10220,17475,14877,16364,14409,18116,15255,8306,15282,4033,9277,19084,6193,13935,7446,11524,4997,1220,8584,13452,8591,6082,14501,179,6279,3807,4900,332,19990,4657,1959,5135,8414,8058,14777,3386,19968,5063,8744,7410,3028,17987,2865,6641,10186,16032,3632,4254,8707,4816,7469,2338,16763,1121,9794,16506,4224,4438,955,8998,873,1875,6663,11329,17828,11944,13643,6382,6626,4205,15214,9727,9160,13082,6751,19031,4153,16900,18548,13703,19181,10414,17067,16250,10233,9052,8533,18149,15154,4633,18510,11425,19580,14177,14273,6804,10439,12065,4845,17367,19822,4920,1075,1939,18447,10246,16904,2175,15721,18857,10356,9888,15005,13227,13141,14791,7663,13137,18101,12216,8870,2203,13741,10923,3868,9621,12550,14647,9722,14035,6510,1757,18772,13995,19885,19905,1962,6066,1718,11479,14045,4737,2965,4709,17127,8142,5231,2581,10559,2573,15360,19683,18244,8463,15057,5474,8295,8449,4261,17031,14890,8739,1948,10646,3378,14156,3094,3759,1792,10732,1622,16212,15123,12931,16285,11772,4521,2817,18200,17443,13742,5541,15021,19878,12990,9442,5443,19057,12424,3116,15614,10439,4754,11182,5524,1057,2966,19959,7071,14609,10671,17033,857,8255,19825,19989,12920,10275,4423,18004,9184,5178,17880,7121,8313,3736,6389,19923,2311,3493,168,14347,8330,8629,12224,8812,13884,11406,16267,19348,9118,8004,8536,6030,15185,68,13462,9352,7235,10851,18839,5247,11035,1666,13194,19749,14127,2152,13255,5710,127,2289,18348,131,7580,19547,5019,5822,16238,18789,19493,5638,3332,10596,19825,18199,17972,495,11640,14072,465,14260,7731,6374,17354,11716,16200,3567,18194,19176,2228,18922,16608,16981,5597,8015,17927,319,1050,7888,12433,4787,3465,19132,15877,18626,5273,16324,8165,7324,16048,5237,9872,8562,12541,19007,1885,19877,11446,9286,4273,12195,10648,15774,12342,18282,9971,4737,2714,6464,7945,140,17114,16886,4720,14636,14574,525,8814,4604,8181,1096,14256,7686,5264,12103,3511,18594,16833,1925,7475,1099,1472,8788,3156,7472,13383,19834,4348,1837,11217,11754,10392,16846,8878,1452,3263,17816,1578,6524,16670,13437,10689,9010,3206,18908,11410,5660,3496,10256,1436,16638,9559,1804,17025,10206,3641,2076,4863,13742,220,78,8263,19602,12486,2148,14834,741,17441,1438,2570,3201,18123,4924,2790,11822,13699,5046,6812,9887,19800,1767,4034,1072,4466,272,3823,17305,13282,13061,9053,217,9387,493,16908,476,1513,6427,3997,17757,2316,11760,14864,2678,5995,2030,6392,5673,9393,2662,1096,13986,6027,17159,15140,1079,11169,15049,17652,12968,2181,3625,11141,7428,7152,1334,14273,12666,2907,19830,8482,9741,15827,9722,10704,17344,17603,18542,740,299,7693,16944,7226,8129,6583,4198,14065,15690,6352,7558,2977,16523,2302,17242,12726,8886,13421,3137,18649,19531,17504,15334,9279,8964,16387,2734,10545,2495,11149,18882,5836,11077,16327,5252,15881,9200,16089,14371,9329,13722,18729,12170,14186,18036,16588,6082,11993,15046,1318,4422,18509,19736,9784,9523,18111,9554,7766,11423,9507,18112,16819,18435,7270,9647,5131,15575,4876,13379,6482,4853,19452,11425,14181,19516,1076,1043,12615,6065,12546,8993,5464,17415,9612,10968,8719,18611,14226,9721,3624,16059,17453,5323,7636,11786,12773,4840,1093,4508,9756,14687,3791,10275,8757,14392,6526,12318,5599,5533,15166,4253,14947,1082,9554,14674,7081,14523,8675,11216,2319,13270,7008,12688,18258,3694,9317,884,2420,12081,16158,13171,15366,2756,11770,4408,5912,5644,9031,7270,2071,9336,6228,3603,8082,3612,16475,13312,10250,4914,6331,1896,14169,8020,239,13548,16189,17659,14422,7398,19743,11425,10592,5023,14675,15913,7317,11421,16326,14458,12645,15085,2286,5402,2988,6530,18820,12324,14004,18636,4565,8147,1940,17710,15703,7338,19962,10841,17409,3175,3632,9871,2740,16132,18239,3612,11584,9408,14062,15529,15607,10454,17989,2694,14285,13635,2630,10018,15305,16778,3717,9539,15985,8054,10675,10618,6881,8565,11070,11886,7531,14257,19091,3180,1506,17230,1839,11586,12261,12987,18311,17540,18340,7724,19448,8163,2718,4172,13430,8528,6069,1850,12208,13230,4499,9481,6252,4500,1504,11473,16344,19506,15424,10215,19685,19874,6499,16037,684,9623,19473,10531,13850,7742,9334,19507,16863,10257,17993,923,9951,765,12193,5451,2227,8015,11000,3007,9486,2437,5016,18999,1026,1321,885,10237,14691,14756,16371,2732,8271,2410,14956,9944,1910,1270,18785,16018,15485,16870,7268,2793,9703,7045,15738,11409,7774,4259,14598,7527,5948,5879,17125,11928,11034,9443,7717,19722,8768,14631,12586,17274,18269,11633,16092,2492,14581,13611,15963,7132,12446,16565,17592,18552,14314,566,17937,11532,14365,4047,13901,6112,16650,11219,16554,17049,18743,18107,12936,9312,18171,9196,9643,19687,11050,8228,1977,14777,15166,10383,12951,5049,14579,17113,14333,13589,4914,998,10989,19904,5904,3989,9694,17707,8465,150,2968,5980,5361,9686,15263,278,6218,15228,13830,15493,1516,19212,3747,9818,10702,3792,17259,1295,16880,5444,10755,17530,11954,663,7625,15337,2904,4544,4783,2848,4013,1460,13383,13868,15332,5325,14727,277,12506,16297,13454,3728,7303,16919,15294,11074,16221,5000,3861,6271,7808,12004,13274,13111,9770,14588,14246,1862,2390,7169,19949,18364,2646,15906,4361,14849,1381,1743,3065,16428,13276,6609,331,5602,8865,4233,4798,74,19350,14781,8897,14538,19581,2130,16269,14805,16038,19865,18847,19870,3164,4747,6023,11779,7533,1411,2161,2755,3229,794,19426,10362,19761,3726,14660,11469,4460,16420,6162,4715,2278,7867,9926,14291,14531,7127,12676,3415,9471,2658,1319,16821,8337,1790,8820,7296,3780,19804,8742,13882,16266,16089,5784,170,1423,10891,5533,14422,14018,2026,13432,7643,19548,9174,2502,15654,16377,19704,16428,14804,6641,12554,1016,13598,8520,18599,14434,12552,16443,1623,8926,3266,19042,19587,6803,9934,18590,1006,17198,5048,4286,962,18689,14339,17822,2093,3113,19620,14204,13061,13781,6594};//int a[] = {4, 3, 7, 5, 6, 4, 2};
		int days = daysRequiredToDie(a);
		System.out.print(days);

	}

}
