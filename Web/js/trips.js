gx.evt.autoSkip=!1;gx.define("trips",!1,function(){var n,t;this.ServerClass="trips";this.PackageName="com.kbbaru";this.ServerFullClass="com.kbbaru.trips";this.setObjectType("trn");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="KBBaru";this.SetStandaloneVars=function(){};this.Valid_Tripsid=function(){return this.validSrvEvt("valid_Tripsid",0).then(function(n){return n}.closure(this))};this.Valid_Attractionsid=function(){var t=gx.fn.currentGridRowImpl(53),n;return gx.fn.currentGridRowImpl(53)===0?!0:(n=gx.util.balloon.getNew("ATTRACTIONSID",gx.fn.currentGridRowImpl(53)),gx.fn.gridDuplicateKey(54))?(n.setError(gx.text.format(gx.getMessage("GXM_1004"),"Attrations","","","","","","","","")),this.AnyError=gx.num.trunc(1,0),n.show()):this.validSrvEvt("valid_Attractionsid",53).then(function(n){try{this.sMode16=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(16,53);this.standaloneModal0816();this.standaloneNotModal0816()}finally{this.Gx_mode=this.sMode16}return n}.closure(this))};this.standaloneModal0816=function(){try{gx.text.compare(this.Gx_mode,"INS")!=0?gx.fn.setCtrlProperty("ATTRACTIONSID","Enabled",0):gx.fn.setCtrlProperty("ATTRACTIONSID","Enabled",1)}catch(n){}};this.standaloneNotModal0816=function(){};this.e110815_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e120815_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,54,55,56,57,58,59,60,61,62,63,64,65];this.GXLastCtrlId=65;this.Gridtrips_attrationsContainer=new gx.grid.grid(this,16,"Attrations",53,"Gridtrips_attrations","Gridtrips_attrations","Gridtrips_attrationsContainer",this.CmpContext,this.IsMasterPage,"trips",[9],!1,1,!1,!0,5,!1,!1,!1,"",0,"px",0,"px","New row",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.Gridtrips_attrationsContainer;t.addSingleLineEdit(9,54,"ATTRACTIONSID","Attractions Id","","AttractionsId","int",0,"px",4,4,"right",null,[],9,"AttractionsId",!0,0,!1,!1,"Attribute",0,"");t.addBitmap("prompt_9","PROMPT_9",65,0,"",0,"",null,"","","gx-prompt Image","");t.addSingleLineEdit(10,55,"ATTRACTIONSNAME","Attractions Name","","AttractionsName","svchar",0,"px",40,40,"left",null,[],10,"AttractionsName",!0,0,!1,!1,"Attribute",0,"");this.Gridtrips_attrationsContainer.emptyText="";this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TITLECONTAINER",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"FORMCONTAINER",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"TOOLBARCELL",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"BTN_FIRST",grid:0,evt:"e130815_client",std:"FIRST"};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"BTN_PREVIOUS",grid:0,evt:"e140815_client",std:"PREVIOUS"};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"BTN_NEXT",grid:0,evt:"e150815_client",std:"NEXT"};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"BTN_LAST",grid:0,evt:"e160815_client",std:"LAST"};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"BTN_SELECT",grid:0,evt:"e170815_client",std:"SELECT"};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[34]={id:34,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Tripsid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Gridtrips_attrationsContainer],fld:"TRIPSID",fmt:0,gxz:"Z25TripsId",gxold:"O25TripsId",gxvar:"A25TripsId",ucs:[],op:[44,39],ip:[44,39,34],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A25TripsId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z25TripsId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TRIPSID",gx.O.A25TripsId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A25TripsId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TRIPSID",",")},nac:gx.falseFn};this.declareDomainHdlr(34,function(){});n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};n[39]={id:39,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRIPSDATE",fmt:0,gxz:"Z26TripsDate",gxold:"O26TripsDate",gxvar:"A26TripsDate",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A26TripsDate=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z26TripsDate=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("TRIPSDATE",gx.O.A26TripsDate,0)},c2v:function(){this.val()!==undefined&&(gx.O.A26TripsDate=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("TRIPSDATE")},nac:gx.falseFn};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"",grid:0};n[44]={id:44,lvl:0,type:"svchar",len:200,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRIPSDESCRIPTION",fmt:0,gxz:"Z27TripsDescription",gxold:"O27TripsDescription",gxvar:"A27TripsDescription",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A27TripsDescription=n)},v2z:function(n){n!==undefined&&(gx.O.Z27TripsDescription=n)},v2c:function(){gx.fn.setControlValue("TRIPSDESCRIPTION",gx.O.A27TripsDescription,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A27TripsDescription=this.val())},val:function(){return gx.fn.getControlValue("TRIPSDESCRIPTION")},nac:gx.falseFn};this.declareDomainHdlr(44,function(){});n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"ATTRATIONSTABLE",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"TITLEATTRATIONS",format:0,grid:0,ctrltype:"textblock"};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[54]={id:54,lvl:16,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,isacc:1,grid:53,gxgrid:this.Gridtrips_attrationsContainer,fnc:this.Valid_Attractionsid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ATTRACTIONSID",fmt:0,gxz:"Z9AttractionsId",gxold:"O9AttractionsId",gxvar:"A9AttractionsId",ucs:[],op:[55],ip:[55,54],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A9AttractionsId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z9AttractionsId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("ATTRACTIONSID",n||gx.fn.currentGridRowImpl(53),gx.O.A9AttractionsId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A9AttractionsId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("ATTRACTIONSID",n||gx.fn.currentGridRowImpl(53),",")},nac:gx.falseFn};n[55]={id:55,lvl:16,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:1,grid:53,gxgrid:this.Gridtrips_attrationsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ATTRACTIONSNAME",fmt:0,gxz:"Z10AttractionsName",gxold:"O10AttractionsName",gxvar:"A10AttractionsName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A10AttractionsName=n)},v2z:function(n){n!==undefined&&(gx.O.Z10AttractionsName=n)},v2c:function(n){gx.fn.setGridControlValue("ATTRACTIONSNAME",n||gx.fn.currentGridRowImpl(53),gx.O.A10AttractionsName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A10AttractionsName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("ATTRACTIONSNAME",n||gx.fn.currentGridRowImpl(53))},nac:gx.falseFn};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"BTN_ENTER",grid:0,evt:"e110815_client",std:"ENTER"};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"BTN_CANCEL",grid:0,evt:"e120815_client"};n[63]={id:63,fld:"",grid:0};n[64]={id:64,fld:"BTN_DELETE",grid:0,evt:"e180815_client",std:"DELETE"};n[65]={id:65,fld:"PROMPT_9",grid:16};this.A25TripsId=0;this.Z25TripsId=0;this.O25TripsId=0;this.A26TripsDate=gx.date.nullDate();this.Z26TripsDate=gx.date.nullDate();this.O26TripsDate=gx.date.nullDate();this.A27TripsDescription="";this.Z27TripsDescription="";this.O27TripsDescription="";this.Z9AttractionsId=0;this.O9AttractionsId=0;this.Z10AttractionsName="";this.O10AttractionsName="";this.A9AttractionsId=0;this.A10AttractionsName="";this.A25TripsId=0;this.A26TripsDate=gx.date.nullDate();this.A27TripsDescription="";this.Events={e110815_client:["ENTER",!0],e120815_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0}],[]];this.EvtParms.REFRESH=[[],[]];this.EvtParms.VALID_TRIPSID=[[{av:"A25TripsId",fld:"TRIPSID",pic:"ZZZ9"},{av:"Gx_mode",fld:"vMODE",pic:"@!"}],[{av:"A26TripsDate",fld:"TRIPSDATE",pic:""},{av:"A27TripsDescription",fld:"TRIPSDESCRIPTION",pic:""},{av:"Gx_mode",fld:"vMODE",pic:"@!"},{av:"Z25TripsId"},{av:"Z26TripsDate"},{av:"Z27TripsDescription"},{ctrl:"BTN_DELETE",prop:"Enabled"},{ctrl:"BTN_ENTER",prop:"Enabled"}]];this.EvtParms.VALID_ATTRACTIONSID=[[{av:"A9AttractionsId",fld:"ATTRACTIONSID",pic:"ZZZ9"},{av:"A10AttractionsName",fld:"ATTRACTIONSNAME",pic:""}],[{av:"A10AttractionsName",fld:"ATTRACTIONSNAME",pic:""}]];this.setPrompt("PROMPT_9",[54]);this.EnterCtrl=["BTN_ENTER"];t.addPostingVar({rfrVar:"Gx_mode"});this.Initialize()});gx.wi(function(){gx.createParentObj(this.trips)})