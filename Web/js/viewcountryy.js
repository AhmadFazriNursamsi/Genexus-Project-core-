gx.evt.autoSkip=!1;gx.define("viewcountryy",!1,function(){var n,t;this.ServerClass="viewcountryy";this.PackageName="com.kbbaru";this.ServerFullClass="com.kbbaru.viewcountryy";this.setObjectType("web");this.anyGridBaseTable=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="KBBaru";this.SetStandaloneVars=function(){this.A5CountryId=gx.fn.getIntegerValue("COUNTRYID",",");this.A5CountryId=gx.fn.getIntegerValue("COUNTRYID",",")};this.Valid_Attractionsid=function(){var n=gx.fn.currentGridRowImpl(24);return this.validCliEvt("Valid_Attractionsid",24,function(){try{if(gx.fn.currentGridRowImpl(24)===0)return!0;var n=gx.util.balloon.getNew("ATTRACTIONSID",gx.fn.currentGridRowImpl(24));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e15252_client=function(){return this.clearMessages(),this.call("com.kbbaru.attractions",["UPD",this.A9AttractionsId],null,["Mode","AttractionsId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14252_client=function(){return this.executeServerEvent("VADD.CLICK",!0,arguments[0],!1,!1)};this.e16252_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e17252_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,25,26,27,28,29,30,31,32,33,34,35,36];this.GXLastCtrlId=36;this.Grid1Container=new gx.grid.grid(this,2,"WbpLvl2",24,"Grid1","Grid1","Grid1Container",this.CmpContext,this.IsMasterPage,"viewcountryy",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px","New row",!1,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.Grid1Container;t.addSingleLineEdit(9,25,"ATTRACTIONSID","Attractions Id","","AttractionsId","int",0,"px",4,4,"right",null,[],9,"AttractionsId",!0,0,!1,!1,"Attribute",0,"");t.addSingleLineEdit(10,26,"ATTRACTIONSNAME","Attractions Name","","AttractionsName","svchar",0,"px",40,40,"left",null,[],10,"AttractionsName",!0,0,!1,!1,"Attribute",0,"");t.addSingleLineEdit(6,27,"COUNTRYNAME","Country Name","","CountryName","svchar",0,"px",40,40,"left",null,[],6,"CountryName",!0,0,!1,!1,"Attribute",0,"");t.addBitmap(11,"ATTRACTIONSPHOTO",28,0,"px",17,"px",null,"","Attractions Photo","ImageAttribute","");t.addSingleLineEdit("Trips",29,"vTRIPS","Trips","","Trips","int",0,"px",4,4,"right",null,[],"Trips","Trips",!0,0,!1,!1,"Attribute",0,"");t.addBitmap("&Edit","vEDIT",30,0,"px",17,"px","e15252_client","","","Image","");t.addSingleLineEdit("Add",31,"vADD","add","","add","char",0,"px",20,20,"left","e14252_client",[],"Add","add",!0,0,!1,!1,"Attribute",0,"");this.Grid1Container.emptyText="";this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COUNTRYNAME",fmt:0,gxz:"Z6CountryName",gxold:"O6CountryName",gxvar:"A6CountryName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A6CountryName=n)},v2z:function(n){n!==undefined&&(gx.O.Z6CountryName=n)},v2c:function(){gx.fn.setControlValue("COUNTRYNAME",gx.O.A6CountryName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A6CountryName=this.val())},val:function(){return gx.fn.getControlValue("COUNTRYNAME")},nac:gx.falseFn};this.declareDomainHdlr(8,function(){});n[9]={id:9,fld:"",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"TABLE1",grid:0};n[12]={id:12,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"",grid:0};n[16]={id:16,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vATTRACTIONNAME",fmt:0,gxz:"ZV5attractionName",gxold:"OV5attractionName",gxvar:"AV5attractionName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV5attractionName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV5attractionName=n)},v2c:function(){gx.fn.setControlValue("vATTRACTIONNAME",gx.O.AV5attractionName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV5attractionName=this.val())},val:function(){return gx.fn.getControlValue("vATTRACTIONNAME")},nac:gx.falseFn};this.declareDomainHdlr(16,function(){});n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vATTRACTIONNAMETO",fmt:0,gxz:"ZV6attractionNameto",gxold:"OV6attractionNameto",gxvar:"AV6attractionNameto",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV6attractionNameto=n)},v2z:function(n){n!==undefined&&(gx.O.ZV6attractionNameto=n)},v2c:function(){gx.fn.setControlValue("vATTRACTIONNAMETO",gx.O.AV6attractionNameto,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV6attractionNameto=this.val())},val:function(){return gx.fn.getControlValue("vATTRACTIONNAMETO")},nac:gx.falseFn};this.declareDomainHdlr(21,function(){});n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[25]={id:25,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:24,gxgrid:this.Grid1Container,fnc:this.Valid_Attractionsid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ATTRACTIONSID",fmt:0,gxz:"Z9AttractionsId",gxold:"O9AttractionsId",gxvar:"A9AttractionsId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A9AttractionsId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z9AttractionsId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("ATTRACTIONSID",n||gx.fn.currentGridRowImpl(24),gx.O.A9AttractionsId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A9AttractionsId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("ATTRACTIONSID",n||gx.fn.currentGridRowImpl(24),",")},nac:gx.falseFn};n[26]={id:26,lvl:2,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:24,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ATTRACTIONSNAME",fmt:0,gxz:"Z10AttractionsName",gxold:"O10AttractionsName",gxvar:"A10AttractionsName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A10AttractionsName=n)},v2z:function(n){n!==undefined&&(gx.O.Z10AttractionsName=n)},v2c:function(n){gx.fn.setGridControlValue("ATTRACTIONSNAME",n||gx.fn.currentGridRowImpl(24),gx.O.A10AttractionsName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A10AttractionsName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("ATTRACTIONSNAME",n||gx.fn.currentGridRowImpl(24))},nac:gx.falseFn};n[27]={id:27,lvl:2,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:24,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COUNTRYNAME",fmt:0,gxz:"Z6CountryName",gxold:"O6CountryName",gxvar:"A6CountryName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A6CountryName=n)},v2z:function(n){n!==undefined&&(gx.O.Z6CountryName=n)},v2c:function(n){gx.fn.setGridControlValue("COUNTRYNAME",n||gx.fn.currentGridRowImpl(24),gx.O.A6CountryName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A6CountryName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("COUNTRYNAME",n||gx.fn.currentGridRowImpl(24))},nac:gx.falseFn};n[28]={id:28,lvl:2,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:24,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ATTRACTIONSPHOTO",fmt:0,gxz:"Z11AttractionsPhoto",gxold:"O11AttractionsPhoto",gxvar:"A11AttractionsPhoto",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A11AttractionsPhoto=n)},v2z:function(n){n!==undefined&&(gx.O.Z11AttractionsPhoto=n)},v2c:function(n){gx.fn.setGridMultimediaValue("ATTRACTIONSPHOTO",n||gx.fn.currentGridRowImpl(24),gx.O.A11AttractionsPhoto,gx.O.A40001AttractionsPhoto_GXI)},c2v:function(n){gx.O.A40001AttractionsPhoto_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.A11AttractionsPhoto=this.val(n))},val:function(n){return gx.fn.getGridControlValue("ATTRACTIONSPHOTO",n||gx.fn.currentGridRowImpl(24))},val_GXI:function(n){return gx.fn.getGridControlValue("ATTRACTIONSPHOTO_GXI",n||gx.fn.currentGridRowImpl(24))},gxvar_GXI:"A40001AttractionsPhoto_GXI",nac:gx.falseFn};n[29]={id:29,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,isacc:0,grid:24,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vTRIPS",fmt:0,gxz:"ZV7Trips",gxold:"OV7Trips",gxvar:"AV7Trips",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV7Trips=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV7Trips=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("vTRIPS",n||gx.fn.currentGridRowImpl(24),gx.O.AV7Trips,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV7Trips=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("vTRIPS",n||gx.fn.currentGridRowImpl(24),",")},nac:gx.falseFn};n[30]={id:30,lvl:2,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:24,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vEDIT",fmt:0,gxz:"ZV9edit",gxold:"OV9edit",gxvar:"AV9edit",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV9edit=n)},v2z:function(n){n!==undefined&&(gx.O.ZV9edit=n)},v2c:function(n){gx.fn.setGridMultimediaValue("vEDIT",n||gx.fn.currentGridRowImpl(24),gx.O.AV9edit,gx.O.AV14Edit_GXI)},c2v:function(n){gx.O.AV14Edit_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.AV9edit=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vEDIT",n||gx.fn.currentGridRowImpl(24))},val_GXI:function(n){return gx.fn.getGridControlValue("vEDIT_GXI",n||gx.fn.currentGridRowImpl(24))},gxvar_GXI:"AV14Edit_GXI",nac:gx.falseFn,evt:"e15252_client"};n[31]={id:31,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:0,isacc:0,grid:24,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vADD",fmt:0,gxz:"ZV10add",gxold:"OV10add",gxvar:"AV10add",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV10add=n)},v2z:function(n){n!==undefined&&(gx.O.ZV10add=n)},v2c:function(n){gx.fn.setGridControlValue("vADD",n||gx.fn.currentGridRowImpl(24),gx.O.AV10add,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV10add=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vADD",n||gx.fn.currentGridRowImpl(24))},nac:gx.falseFn,evt:"e14252_client"};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vTOTAL",fmt:0,gxz:"ZV11total",gxold:"OV11total",gxvar:"AV11total",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV11total=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV11total=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vTOTAL",gx.O.AV11total,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV11total=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vTOTAL",",")},nac:gx.falseFn};this.A6CountryName="";this.Z6CountryName="";this.O6CountryName="";this.AV5attractionName="";this.ZV5attractionName="";this.OV5attractionName="";this.AV6attractionNameto="";this.ZV6attractionNameto="";this.OV6attractionNameto="";this.Z9AttractionsId=0;this.O9AttractionsId=0;this.Z10AttractionsName="";this.O10AttractionsName="";this.Z11AttractionsPhoto="";this.O11AttractionsPhoto="";this.ZV7Trips=0;this.OV7Trips=0;this.ZV9edit="";this.OV9edit="";this.ZV10add="";this.OV10add="";this.AV11total=0;this.ZV11total=0;this.OV11total=0;this.A6CountryName="";this.AV5attractionName="";this.AV6attractionNameto="";this.AV11total=0;this.A40001AttractionsPhoto_GXI="";this.A5CountryId=0;this.A40000GXC1=0;this.A9AttractionsId=0;this.A10AttractionsName="";this.A11AttractionsPhoto="";this.AV7Trips=0;this.AV9edit="";this.AV10add="";this.Events={e14252_client:["VADD.CLICK",!0],e16252_client:["ENTER",!0],e17252_client:["CANCEL",!0],e15252_client:["VEDIT.CLICK",!1]};this.EvtParms.REFRESH=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{av:"AV5attractionName",fld:"vATTRACTIONNAME",pic:""},{av:"AV6attractionNameto",fld:"vATTRACTIONNAMETO",pic:""},{av:"A5CountryId",fld:"COUNTRYID",pic:"ZZZ9"},{av:"AV9edit",fld:"vEDIT",pic:""},{av:"AV10add",fld:"vADD",pic:""},{av:"AV11total",fld:"vTOTAL",pic:"ZZZ9"}],[]];this.EvtParms["VEDIT.CLICK"]=[[{av:"A9AttractionsId",fld:"ATTRACTIONSID",pic:"ZZZ9",hsh:!0}],[]];this.EvtParms["GRID1.LOAD"]=[[{av:"AV11total",fld:"vTOTAL",pic:"ZZZ9"}],[{av:"AV7Trips",fld:"vTRIPS",pic:"ZZZ9"},{av:"A40000GXC1",fld:"GXC1",pic:"999999999"},{av:"AV11total",fld:"vTOTAL",pic:"ZZZ9"}]];this.EvtParms["GRID1.REFRESH"]=[[],[{av:"AV11total",fld:"vTOTAL",pic:"ZZZ9"}]];this.EvtParms["VADD.CLICK"]=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{av:"AV5attractionName",fld:"vATTRACTIONNAME",pic:""},{av:"AV6attractionNameto",fld:"vATTRACTIONNAMETO",pic:""},{av:"A5CountryId",fld:"COUNTRYID",pic:"ZZZ9"},{av:"AV9edit",fld:"vEDIT",pic:""},{av:"AV10add",fld:"vADD",pic:""},{av:"AV11total",fld:"vTOTAL",pic:"ZZZ9"},{av:"A9AttractionsId",fld:"ATTRACTIONSID",pic:"ZZZ9",hsh:!0}],[{av:"AV7Trips",fld:"vTRIPS",pic:"ZZZ9"}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_ATTRACTIONSID=[[],[]];this.setVCMap("A5CountryId","COUNTRYID",0,"int",4,0);this.setVCMap("A5CountryId","COUNTRYID",0,"int",4,0);this.setVCMap("A5CountryId","COUNTRYID",0,"int",4,0);t.addRefreshingVar(this.GXValidFnc[16]);t.addRefreshingVar(this.GXValidFnc[21]);t.addRefreshingVar({rfrVar:"A5CountryId"});t.addRefreshingVar({rfrVar:"AV9edit",rfrProp:"Value",gxAttId:"Edit"});t.addRefreshingVar({rfrVar:"AV10add",rfrProp:"Value",gxAttId:"Add"});t.addRefreshingVar(this.GXValidFnc[36]);t.addRefreshingParm(this.GXValidFnc[16]);t.addRefreshingParm(this.GXValidFnc[21]);t.addRefreshingParm({rfrVar:"A5CountryId"});t.addRefreshingParm({rfrVar:"AV9edit",rfrProp:"Value",gxAttId:"Edit"});t.addRefreshingParm({rfrVar:"AV10add",rfrProp:"Value",gxAttId:"Add"});t.addRefreshingParm(this.GXValidFnc[36]);this.Initialize()});gx.wi(function(){gx.createParentObj(this.viewcountryy)})