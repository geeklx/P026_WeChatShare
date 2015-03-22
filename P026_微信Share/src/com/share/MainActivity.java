package com.share;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView shareall;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// showShare();
		shareall = (TextView) findViewById(R.id.shareall);
		shareall.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showShare();
			}
		});
	}

	private void showShare() {
		ShareSDK.initSDK(this);
		OnekeyShare oks = new OnekeyShare();
		// 关闭sso授权
		oks.disableSSOWhenAuthorize();

		// 分享时Notification的图标和文字
		oks.setNotification(R.drawable.ic_launcher, getString(R.string.ctone));
		// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
		oks.setTitle(getString(R.string.share));
		// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
		oks.setTitleUrl("http://www.ctone.net/");
		// text是分享文本，所有平台都需要这个字段
		oks.setText("Coding changes the world.");
		// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
		//oks.setImagePath("http://img0.bdstatic.com/img/image/shouye/muzrxc1.jpg");
		// url仅在微信（包括好友和朋友圈）中使用
		oks.setUrl("http://www.ctone.net/");
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
		oks.setComment("亲，留个言吧！");
		// site是分享此内容的网站名称，仅在QQ空间使用
		oks.setSite(getString(R.string.ctone));
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl("http://www.ctone.net/");

		// 启动分享GUI
		oks.show(this);
	}

}
