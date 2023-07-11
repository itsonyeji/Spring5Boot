//agree
let agree1= document.querySelector("#agree1");
let agree2= document.querySelector("#agree2");
let okagree= document.querySelector("#okagree");
let noagree= document.querySelector("#noagree");

okagree?.addEventListener('click', ()=> {
    if(!agree1.checked)  alert('이용약관에 동의에 체크하세요!');
    else if(!agree2.checked) alert('개인정보 이용 동의에 체크하세요!');
    else location.href='/join/checkme';
});
noagree?.addEventListener('click', ()=>{
    location.href="/";
});


// checkme
let frm=document.forms.agreefrm2;/*주소창에 params를 넘기는 방법은 정보가 다 노출됨*/
let checkbtn2=document.querySelector('#checkbtn2');
let cancelbtn2=document.querySelector('#cancelbtn2');

checkbtn2?.addEventListener('click', ()=>{
    if(frm.name.value==='') alert('이름을 입력하세요!');
    else if(frm.jumin1.value==='') alert('주민번호를 입력하세요!');
    else if(frm.jumin2.value==='') alert('나머지 주민번호를 입력하세요!');
    else if(!frm.infoagree.checked) alert('주민등록번호 처리 동의에 체크하세요!');
    else {
        frm.method='post';
        frm.submit();
    }
});
cancelbtn2?.addEventListener('click', ()=>{
    location.href="/";
});

//joinme
let fzipbtn=document.querySelector('#findzipbtn');
let zipbtn=document.querySelector('#zipbtn');
let dong=document.querySelector('#dong');
let zipmodal=document.querySelector('#zipmodal')

let addrlist=document.querySelector('#addrlist');
let sendzip=document.querySelector('#sendzip');

let email3=document.querySelector('#email3');

let modal=null; //우편번호 모달

// 우편번호 검색 모달창 띄우기
zipbtn?.addEventListener('click', () => {
    while(addrlist.lastChild){
        addrlist.removeChild(addrlist.lastChild);    //자식(addlist의 하위요소)을 지움    요소명.함수명(대상)
    }   // 이전 검색 결과 지움
    dong.value='';   // 이전 검색 키워드 지움

    try{
        //새로운 모달 창 생성
        modal=new bootstrap.Modal(zipmodal, {});
    }catch (e) { }
    modal.show();

});

// 검색한 우편번호 결과 출력
const showzipaddr = (jsons) => {
    jsons=JSON.parse(jsons); //문자열을 json객체로 변환
    let addr='';
    jsons.forEach(function (data, idx){ //json 반복처리
        // 조소의 번지가 null인 경우 처리
        //key가 bunji인 데이터값이 비었을때 빈칸으로.
        let bunji = (data['bunji'] != null) ? data['bunji'] :'';

        addr += `<option>${data['zipcode']} ${data['sido']} ${data['gugun']} ${data['dong']} ${bunji}</option>`;
        //key가 zipcode인 값을 출력
    });
    addrlist.innerHTML=addr;
};

// 우편번호 검색
fzipbtn?.addEventListener('click', ()=>{
    if (dong.value === '') {
        alert('동이름을 입력하세요!');
        return;
    }
    const url='/join/zipcode?dong='+dong.value;
    fetch(url).then(response => response.text())
        .then(text=>showzipaddr(text));
    //url을 받아오고, 문자로 바꿈.
});

// 주소 선택하고 닫기
sendzip?.addEventListener('click', () => {
    let frm=document.forms.joinfrm
    let addr = addrlist.value;  //선택한 주소 항목
    if (addr !== ''){
        // 123-456 서울 관악구 신림동
        let zip = addr.split(' ')[0];   // 우편번호 추출 : 공백으로 자른것의 첫번째를 가져온다.
        let addrs=addr.split(' ');
        let vaddr=`${addrs[1]} ${addrs[2]} ${addrs[3]}` // 주소 추출

        frm.zip1.value=zip.split('-')[0];
        frm.zip2.value=zip.split('-')[1];
        frm.addr1.value=vaddr;

        modal.hide();   //모달창 닫음
    }else
        alert('주소를 선택하세요!');
});

// 전자우편 주소 선택
email3?.addEventListener('click', () => {
    let frm = document.forms.joinfrm;
    if(email3.value === '직접입력하기'){
        frm.email2.readOnly = false;
        frm.email2.value='';
    }else if(email3.value !== '선택하세요'){
        frm.email2.readOnly=true;
        frm.email2.value=email3.value;
    }
});

// 우편번호 검색 엔터키 입력 차단
dong?.addEventListener('keydown', (e)=>{
    if(e.keyCode === 13)    // 엔터키(13)가 입력되면
        e.preventDefault(); // 이벤트 전파 방지
});

// 비밀번호 확인
let pwd = document.querySelector('#pwd');
let repwd = document.querySelector('#repasswd');
let pwdmsg = document.querySelector('#pwdmsg')

repwd?.addEventListener('blur',() => {  //포커스가 벗어날때
    let pmsg='비밀번호가 서로 일치하지 않습니다!';
    pwdmsg.className='text-danger';
    if(pwd.value === repwd.value) {
        pmsg = '비밀번호가 서로 일치합니다!';
        pwdmsg.className='text-primary';
    }
    pwdmsg.innerText=pmsg;
});

// 아이디 중복 검사
let userid = document.querySelector('#uid');
let checkuid = document.querySelector('#checkuid');
let uidmsg=document.querySelector('#uidmsg');
const styleCheckuid = (chkuid) => {
    let umsg='사용 불가능한 아이디입니다!';
    uidmsg.className='text-danger';
    checkuid.value='no';

    if(chkuid==='0') {
        umsg = '사용 가능한 아이디입니다!';
        uidmsg.className='text-primary';
        checkuid.value='yes';
    }
    uidmsg.innerText=umsg;
    return undefined;
};

// 아이디 중복 검사
userid?.addEventListener('blur', ()=>{
    if (userid.value === '') {
        uidmsg.innerText='6~16 자의 영문 소문자, 숫자와 특수기호(_)만 사용할 수 있습니다';
        uidmsg.className='text-warning';
        checkuid.value='no';
        return;
    }
    const url='/join/checkuid/'+userid.value;
    fetch(url).then(response => response.text())
        .then(text=>styleCheckuid(text));

});

// 회원정보 저장
let joinbtn = document.querySelector('#joinbtn');
joinbtn?.addEventListener('click', ()=>{
    let frm = document.forms.joinfrm;
    if(frm.userid.value === '')   alert('아이디를 입력하세요!');
    else if(frm.passwd.value === '')   alert('비밀번호를 입력하세요!');
    else if(frm.repasswd.value === '')   alert('비밀번호 확인을 입력하세요!');
    else if(frm.zip1.value === ''|| frm.zip2.value === '')   alert('우편번호를 입력하세요!');
    else if(frm.addr1.value === ''|| frm.addr2.value === '')   alert('주소를 입력하세요!');
    else if(frm.email1.value === ''|| frm.email2.value === '')   alert('이메일을 입력하세요!');
    else if(frm.phone2.value === ''|| frm.phone3.value === '')   alert('전화번호를 입력하세요!');
    else if(grecaptcha.getResponse() === '')   alert('자동방지가입을 확인하세요!');
    else if(checkuid.value === 'no')   alert('아이디 중복검사를 하세요!');
    else{
        frm.jumin.value=frm.jumin1.value+'-'+frm.jumin2.value;
        frm.zipcode.value=frm.zip1.value+'-'+frm.zip2.value;
        frm.email.value=frm.email1.value+'@'+frm.email2.value;
        frm.phone.value=frm.phone1.value+'-'+frm.phone2.value+'-'+frm.phone3.value;

        frm.method='post';
        frm.submit();
        alert('--');
    }

});

// joinok
let go2idx = document.querySelector('#go2idx');
go2idx?.addEventListener('click', ()=> {
    location.href = '/';
});


// login
let loginbtn = document.querySelector("#loginbtn");
let lguid = document.querySelector("#userid");
let lgpwd = document.querySelector("#passwd");
let lgfrm = document.querySelector('#lgnfrm');

loginbtn?.addEventListener('click', ()=>{
   if(lguid.value=='')  alert('아이디를 입력하세요!');
   else if(lgpwd.value=='')  alert('비밀번호를 입력하세요!');
   else{
       lgfrm.method='post';
       lgfrm.action='/join/login'
       lgfrm.submit();
   }
});

// logout
let lgoutbtn = document.querySelector('#lgoutbtn');

lgoutbtn?.addEventListener('click', ()=>{
    location.href='/join/logout';
});