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
		// �ر�sso��Ȩ
		oks.disableSSOWhenAuthorize();

		// ����ʱNotification��ͼ�������
		oks.setNotification(R.drawable.ic_launcher, getString(R.string.ctone));
		// title���⣬ӡ��ʼǡ����䡢��Ϣ��΢�š���������QQ�ռ�ʹ��
		oks.setTitle(getString(R.string.share));
		// titleUrl�Ǳ�����������ӣ�������������QQ�ռ�ʹ��
		oks.setTitleUrl("http://www.ctone.net/");
		// text�Ƿ����ı�������ƽ̨����Ҫ����ֶ�
		oks.setText("Coding changes the world.");
		// imagePath��ͼƬ�ı���·����Linked-In�����ƽ̨��֧�ִ˲���
		//oks.setImagePath("http://img0.bdstatic.com/img/image/shouye/muzrxc1.jpg");
		// url����΢�ţ��������Ѻ�����Ȧ����ʹ��
		oks.setUrl("http://www.ctone.net/");
		// comment���Ҷ�������������ۣ�������������QQ�ռ�ʹ��
		oks.setComment("�ף������԰ɣ�");
		// site�Ƿ�������ݵ���վ���ƣ�����QQ�ռ�ʹ��
		oks.setSite(getString(R.string.ctone));
		// siteUrl�Ƿ�������ݵ���վ��ַ������QQ�ռ�ʹ��
		oks.setSiteUrl("http://www.ctone.net/");

		// ��������GUI
		oks.show(this);
	}

}
