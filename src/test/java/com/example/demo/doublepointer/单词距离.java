package com.example.demo.doublepointer;

import org.junit.Test;

/**
 *有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"],
 * 输出：1
 * 提示：
 *
 * words.length <= 100000
 *
 * @author yanghaiyu
 * @date 2020/06/30 
 **/
public class 单词距离 {
	public int findClosest(String[] words, String word1, String word2) {
		int distance = 0;
		for (int i = 0; i < words.length; i++) {
			if (word1.equals(words[i]) || word2.equals(words[i])) {
				for (int j = i + 1; j < words.length; j++) {
					if (word1.equals(words[j]) || word2.equals(words[j])) {
						if (words[i].equals(words[j])) {
							i = j-1;
							break;
						} else {
							distance = distance == 0 ? j - i : Math.min((j - i), distance);
							if (distance == 1) {
								return distance;
							}
							i = j-1;
							break;
						}

					}

				}
			}

		}
		return distance;

	}

	@Test
	public void t1() {
		String[] arr = {
				"w","ue","sf","u","thv","wvd","g","lj","dz","ync","tbo","tn","uir","i","w","izu","uq","au","mh","l","oz","yk","pb","ypa","ho","ny","uxa","p","pjw","iw","liz","w","knu","aq","wy","pp","s","na","t","uwv","n","b","lc","guc","bq","ir","rpx","pbk","kv","th","qm","xv","kgw","bl","bd","hwj","y","b","yxq","hj","p","tsn","qp","jl","jb","vtv","t","w","cq","zk","q","s","hf","hw","fd","tn","t","gv","zf","xjp","ipe","hov","yw","v","ftm","o","pf","v","zc","uwb","gp","ql","wew","lj","r","hto","u","nsk","n","nn","ivd","x","s","g","nmp","xr","jg","qru","ora","ir","yfd","krg","gj","j","u","it","uk","v","uu","m","bx","lls","mp","kto","a","u","po","i","ytb","lo","azc","w","pnf","fqz","f","n","g","mz","bb","t","ldi","iqx","vd","wer","ut","wbn","x","kz","ha","yi","sd","diq","p","jgg","ev","el","wya","z","wth","ys","mj","o","qg","t","xo","wz","xc","ei","jec","s","nzw","gs","eg","qnn","c","e","h","kn","dsl","v","tqv","uj","v","kn","mn","n","pb","s","fx","ij","dxs","ozm","ib","lmp","ej","hkp","cs","v","tss","e","riz","bc","zd","y","bqq","tn","cs","i","dfj","wfg","t","hkm","iw","ve","pfv","t","l","kuz","p","tzy","rg","fht","f","xi","hfh","sv","zwb","jgj","l","rna","iag","is","y","ebg","rrh","fmm","b","oid","t","t","ozu","sbc","v","l","h","kv","i","mfc","lmd","f","hod","va","r","o","pdy","g","q","if","roc","yqr","g","eje","t","f","tk","jdx","ggt","nd","zj","u","uvb","s","y","u","ao","xr","mj","e","icz","q","stl","iog","llg","e","yfo","j","bp","hib","j","py","zmq","j","x","tcf","ftq","kev","li","fe","kwj","cn","u","ox","ql","bg","t","o","sfv","ggb","mc","gf","fn","axd","n","t","uz","y","gpt","il","r","o","z","jc","pie","lka","kw","l","sz","ci","hf","a","jis","z","ccm","c","ao","on","w","h","cgc","ekj","bq","c","zic","nus","uk","die","z","o","j","vn","pw","f","cr","gf","w","me","pp","vmr","pg","v","dv","im","js","ag","sd","h","ufj","nkr","h","mbx","we","jpv","j","gw","hnm","yc","a","dwa","a","kb","qmp","uu","n","lei","zpg","s","haa","s","lj","x","i","fby","s","jid","cp","xgu","i","nkg","ee","r","lr","xba","bq","q","m","l","wxn","lro","j","qzy","tt","vdn","w","bke","cgo","x","rpw","tw","prz","e","let","i","y","zyt","xkz","ig","nfd","mb","p","gg","stc","ggi","bq","ano","xs","kga","q","yr","t","sdz","dxe","cc","qh","y","ti","y","ii","eoy","q","mhr","hki","y","aug","bcg","q","wip","yp","iu","j","yfk","s","j","qv","sxs","kbg","yk","lf","v","fdp","u","d","gpm","dy","u","q","b","c","hkw","e","y","d","bc","wb","ye","u","jpm","q","f","d","c","fcv","p","spe","uy","p","bi","rz","dm","ak","nlw","yv","b","tz","swy","cyl","mi","v","ro","ow","m","g","sa","zqf","o","xvs","pua","hwh","ek","oz","cx","km","m","njb","ffo","zd","oi","gpy","wm","wjw","odg","hi","idw","g","mlz","htf","zia","f","equ","o","t","u","h","k","vr","st","tz","l","cf","u","x","hyp","mm","z","qkf","rb","oo","dr","iq","j","id","jxn","rb","m","n","zx","d","oq","l","r","y","ain","ig","h","fxp","dhl","ip","xv","ivx","wfo","yb","cc","l","f","ot","jlb","s","v","te","e","c","gve","j","d","ro","saa","ixw","o","suu","n","sn","skd","n","m","uys","tw","p","xs","ukg","kc","vzs","i","p","kxt","mek","haw","b","ulk","pk","crr","a","o","hm","mko","m","rl","zzg","gg","sl","pe","zn","tj","tkw","lyb","mj","r","njb","dk","jo","rq","nbe","fnn","ecv","gm","i","iz","r","ttr","mq","l","vzb","c","s","phj","iad","hrz","hdq","nld","qua","sdf","le","e","o","ulf","izf","je","dsq","r","q","xmy","puh","dz","a","gl","gdg","c","avf","leh","s","ubw","pz","byw","zei","trd","a","rhi","sm","gs","al","pnw","fg","dm","zlz","j","q","v","b","nyk","j","hnp","g","bnc","urq","yo","l","x","mwt","hn","yhu","mn","dz","ter","a","ep","g","l","tkj","uee","r","dcu","o","qdh","pod","xqa","wud","e","fnx","rj","zr","qt","mzr","c","sum","ty","duk","kfg","xi","ku","ce","qg","e","qz","f","n","kwm","gx","x","jz","beb","ty","y","z","q","uj","s","bz","lpp","x","oth","spa","dev","r","kg","h","l","n","k","gs","s","pl","jw","b","w","r","nfj","i","i","xzi","atb","k","v","cqn","z","a","yqp","lmf","gm","e","t","y","d","eq","lpa","ohi","jek","ilf","sgi","lza","rmr","dj","vyo","fa","m","r","x","ufe","u","vd","txv","ehh","l","z","p","sd","kzd","aov","hw","ylb","b","hyq","r","mir","rb","v","aj","hgj","vkn","r","o","x","ok","zv","d","m","hsj","ud","j","dur","oh","o","wwh","xt","s","ii","kso","nr","wxv","bsf","zh","rj","xd","df","ix","lo","rhe","n","eeb","fcc","ax","pjl","zo","u","h","hs","tbg","lwb","j","rgl","q","gd","g","syl","tr","h","rul","a","hgg","fmk","m","wf","j","ewp","j","qqw","cam","cf","i","bdp","h","f","g","cmh","fzr","brh","ij","sx","q","aw","ioz","fwl","x","ym","abg","td","i","z","di","eve","kb","b","s","o","ah","azc","no","fwg","al","m","x","qk","kp","n","osk","mpg","xu","u","b","x","osd","o","ll","kav","ika","e","jd","ujg","kz","yf","zal","h","j","da","c","ef","jad","nkq","cer","rf","vf","cul","ji","t","fo","yzq","f","x","k","mu","c","i","e","ikf","aqt","qp","d","zg","tz","xup","ha","h","yad","f","zd","bdx","nv","nh","e","r","ls","yd","hxy","uyv","wa","v","qtd","sea","ci","eui","uc","sjg","ja","sy","qy","xq","nji","c","mo","uv","i","ekc","ep"};
		String word1 = "wew", word2 = "i";
		int closest = findClosest(arr, word1, word2);
		System.out.printf("i");
	}
}
