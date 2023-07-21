// gallery view
let newgalbtn=document.querySelector('#newgalbtn');
let modgalbtn = document.querySelector('#modgalbtn');
let rmvgalbtn = document.querySelector('#rmvgalbtn');
let lstgalbtn = document.querySelector('#lstgalbtn');
newgalbtn?.addEventListener('click', ()=>{
   location.href='/gallery/write';
});

modgalbtn?.addEventListener('click', ()=>{
    if(confirm("정말 수정하시겠어요?")){
        alert('아직 미지원 기능입니다.');
    }
    /*location.href='/gallery/modify';*/
})
rmvgalbtn?.addEventListener('click', ()=>{
    if(confirm("정말 삭제하시겠어요?")){
        alert('아직 미지원 기능입니다.');
    }
    //location.href='/gallery/remove';
})
lstgalbtn?.addEventListener('click', ()=>{
   location.href='/gallery/list/1';
});


// gal write
let wrtgalbtn = document.querySelector("#wrtgalbtn");
let cancelbtn3 = document.querySelector("#cancelbtn3");
wrtgalbtn?.addEventListener('click', ()=>{
    let frm = document.forms.galfrm;
    if(frm.title.value ==='') alert("제목을 입력하세요!");
    else if(frm.contents.value === '') alert("본문을 입력하세요!");
    else if(grecaptcha.getResponse() ==='') alert("자동쓰기방지를 체크하세요!");
    else{
       frm.method='post';
       frm.enctype='multipart/form-data'    /* 첨부기능을 위해서 인코딩타입을 바꿈. 클라이언트가 텍스트와 파일들을 다중으로 보낸다. */
       frm.submit();
       alert('새글 등록이 완료되었습니다.');
    }
});
cancelbtn3?.addEventListener('click', ()=>{
    location.href="/gallery/list/1";
});

// gal find
let findtype = document.querySelector('#findtype');
let findkey = document.querySelector('#findkey');
let findbtn=document.querySelector('#findbtn');
findbtn?.addEventListener('click', ()=>{
   if(findkey.value ==='') alert('검색어를 입력하세요!');
   else{
       location.href=`/gallery/find/${findtype.value}/${findkey.value}/1`;
   }
});

/*
// gal comment
let cmtbtn = document.querySelector('#newcmtbtn');
cmtbtn?.addEventListener('click', ()=>{
    let frm = document.forms.cmtfrm;
    if(frm.userid.value === '') alert('로그인 하세요!');
    else if(frm.pno.value === '') alert('정상적인 접근이 아닙니다.');
    else if(frm.comments.value === '') alert('댓글을 작성하세요!');
    else {
        frm.method = 'post';
        frm.action = '/gal/cmt/write'
        frm.submit();
        alert('댓글이 등록되었습니다.');
    }
});

// gal reply
let modal = null;
const refno = document.querySelector("#ref");
const showReply = (ref) => {
    refno.value = ref;    // 대댓글을 작성할 댓글의 댓글번호cno를 알아냄

    modal = new bootstrap.Modal(replyModal, {});
    modal.show();

};

const replybtn = document.querySelector('#replybtn');
const frm = document.querySelector('#replyfrm');
replybtn?.addEventListener('click', () => {
    if(frm.comments.value === '')   alert('대댓글을 작성하세요!');
    else if(frm.ref.value === '')   alert('댓글번호가 없습니다.');
    else if(frm.pno.value === '')   alert('본문글번호가 없습니다.');
    else{
        frm.method = 'post';
        frm.action = '/gal/reply/write';
        frm.submit();
    }

});
*/



