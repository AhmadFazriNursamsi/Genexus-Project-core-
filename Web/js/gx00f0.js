gx.evt.autoSkip=!1;gx.define("gx00f0",!1,function(){var n,t;this.ServerClass="gx00f0";this.PackageName="com.kbbaru";this.ServerFullClass="com.kbbaru.gx00f0";this.setObjectType("web");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="KBBaru";this.SetStandaloneVars=function(){this.AV8pTripsId=gx.fn.getIntegerValue("vPTRIPSID",",")};this.e13221_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class"),"AdvancedContainer")==0?(gx.fn.setCtrlProperty("ADVANCEDCONTAINER","Class","AdvancedContainer AdvancedContainerVisible"),gx.fn.setCtrlProperty("BTNTOGGLE","Class",gx.fn.getCtrlProperty("BTNTOGGLE","Class")+" BtnToggleActive")):(gx.fn.setCtrlProperty("ADVANCEDCONTAINER","Class","AdvancedContainer"),gx.fn.setCtrlProperty("BTNTOGGLE","Class","BtnToggle")),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e11221_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TRIPSIDFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("TRIPSIDFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCTRIPSID","Visible",!0)):(gx.fn.setCtrlProperty("TRIPSIDFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCTRIPSID","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TRIPSIDFILTERCONTAINER","Class")',ctrl:"TRIPSIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTRIPSID","Visible")',ctrl:"vCTRIPSID",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12221_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TRIPSDATEFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?gx.fn.setCtrlProperty("TRIPSDATEFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"):gx.fn.setCtrlProperty("TRIPSDATEFILTERCONTAINER","Class","AdvancedContainerItem"),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TRIPSDATEFILTERCONTAINER","Class")',ctrl:"TRIPSDATEFILTERCONTAINER",prop:"Class"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16222_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e17221_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,35,36,37,38,39,40];this.GXLastCtrlId=40;this.Grid1Container=new gx.grid.grid(this,2,"WbpLvl2",34,"Grid1","Grid1","Grid1Container",this.CmpContext,this.IsMasterPage,"gx00f0",[],!1,1,!1,!0,10,!0,!1,!1,"",0,"px",0,"px","New row",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.Grid1Container;t.addBitmap("&Linkselection","vLINKSELECTION",35,0,"px",17,"px",null,"","","SelectionAttribute","WWActionColumn");t.addSingleLineEdit(25,36,"TRIPSID","Id","","TripsId","int",0,"px",4,4,"right",null,[],25,"TripsId",!0,0,!1,!1,"Attribute",0,"WWColumn");t.addSingleLineEdit(26,37,"TRIPSDATE","Date","","TripsDate","date",0,"px",8,8,"right",null,[],26,"TripsDate",!0,0,!1,!1,"DescriptionAttribute",0,"WWColumn");this.Grid1Container.emptyText="";this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAIN",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"ADVANCEDCONTAINER",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TRIPSIDFILTERCONTAINER",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"LBLTRIPSIDFILTER",format:1,grid:0,evt:"e11221_client",ctrltype:"textblock"};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"",grid:0};n[16]={id:16,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTRIPSID",fmt:0,gxz:"ZV6cTripsId",gxold:"OV6cTripsId",gxvar:"AV6cTripsId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV6cTripsId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV6cTripsId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCTRIPSID",gx.O.AV6cTripsId,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV6cTripsId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCTRIPSID",",")},nac:gx.falseFn};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"TRIPSDATEFILTERCONTAINER",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"LBLTRIPSDATEFILTER",format:1,grid:0,evt:"e12221_client",ctrltype:"textblock"};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTRIPSDATE",fmt:0,gxz:"ZV7cTripsDate",gxold:"OV7cTripsDate",gxvar:"AV7cTripsDate",dp:{f:-1,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV7cTripsDate=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV7cTripsDate=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("vCTRIPSDATE",gx.O.AV7cTripsDate,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV7cTripsDate=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("vCTRIPSDATE")},nac:gx.falseFn};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"GRIDTABLE",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"BTNTOGGLE",grid:0,evt:"e13221_client"};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[35]={id:35,lvl:2,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:34,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vLINKSELECTION",fmt:0,gxz:"ZV5LinkSelection",gxold:"OV5LinkSelection",gxvar:"AV5LinkSelection",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV5LinkSelection=n)},v2z:function(n){n!==undefined&&(gx.O.ZV5LinkSelection=n)},v2c:function(n){gx.fn.setGridMultimediaValue("vLINKSELECTION",n||gx.fn.currentGridRowImpl(34),gx.O.AV5LinkSelection,gx.O.AV12Linkselection_GXI)},c2v:function(n){gx.O.AV12Linkselection_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.AV5LinkSelection=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vLINKSELECTION",n||gx.fn.currentGridRowImpl(34))},val_GXI:function(n){return gx.fn.getGridControlValue("vLINKSELECTION_GXI",n||gx.fn.currentGridRowImpl(34))},gxvar_GXI:"AV12Linkselection_GXI",nac:gx.falseFn};n[36]={id:36,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:34,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRIPSID",fmt:0,gxz:"Z25TripsId",gxold:"O25TripsId",gxvar:"A25TripsId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A25TripsId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z25TripsId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("TRIPSID",n||gx.fn.currentGridRowImpl(34),gx.O.A25TripsId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A25TripsId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("TRIPSID",n||gx.fn.currentGridRowImpl(34),",")},nac:gx.falseFn};n[37]={id:37,lvl:2,type:"date",len:8,dec:0,sign:!1,ro:1,isacc:0,grid:34,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRIPSDATE",fmt:0,gxz:"Z26TripsDate",gxold:"O26TripsDate",gxvar:"A26TripsDate",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A26TripsDate=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z26TripsDate=gx.fn.toDatetimeValue(n))},v2c:function(n){gx.fn.setGridControlValue("TRIPSDATE",n||gx.fn.currentGridRowImpl(34),gx.O.A26TripsDate,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A26TripsDate=gx.fn.toDatetimeValue(this.val(n)))},val:function(n){return gx.fn.getGridDateTimeValue("TRIPSDATE",n||gx.fn.currentGridRowImpl(34))},nac:gx.falseFn};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"BTN_CANCEL",grid:0,evt:"e17221_client"};this.AV6cTripsId=0;this.ZV6cTripsId=0;this.OV6cTripsId=0;this.AV7cTripsDate=gx.date.nullDate();this.ZV7cTripsDate=gx.date.nullDate();this.OV7cTripsDate=gx.date.nullDate();this.ZV5LinkSelection="";this.OV5LinkSelection="";this.Z25TripsId=0;this.O25TripsId=0;this.Z26TripsDate=gx.date.nullDate();this.O26TripsDate=gx.date.nullDate();this.AV6cTripsId=0;this.AV7cTripsDate=gx.date.nullDate();this.AV8pTripsId=0;this.AV5LinkSelection="";this.A25TripsId=0;this.A26TripsDate=gx.date.nullDate();this.Events={e16222_client:["ENTER",!0],e17221_client:["CANCEL",!0],e13221_client:["'TOGGLE'",!1],e11221_client:["LBLTRIPSIDFILTER.CLICK",!1],e12221_client:["LBLTRIPSDATEFILTER.CLICK",!1]};this.EvtParms.REFRESH=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripsId",fld:"vCTRIPSID",pic:"ZZZ9"},{av:"AV7cTripsDate",fld:"vCTRIPSDATE",pic:""}],[]];this.EvtParms["'TOGGLE'"]=[[{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}]];this.EvtParms["LBLTRIPSIDFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TRIPSIDFILTERCONTAINER","Class")',ctrl:"TRIPSIDFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TRIPSIDFILTERCONTAINER","Class")',ctrl:"TRIPSIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTRIPSID","Visible")',ctrl:"vCTRIPSID",prop:"Visible"}]];this.EvtParms["LBLTRIPSDATEFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TRIPSDATEFILTERCONTAINER","Class")',ctrl:"TRIPSDATEFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TRIPSDATEFILTERCONTAINER","Class")',ctrl:"TRIPSDATEFILTERCONTAINER",prop:"Class"}]];this.EvtParms.ENTER=[[{av:"A25TripsId",fld:"TRIPSID",pic:"ZZZ9",hsh:!0}],[{av:"AV8pTripsId",fld:"vPTRIPSID",pic:"ZZZ9"}]];this.EvtParms.GRID1_FIRSTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripsId",fld:"vCTRIPSID",pic:"ZZZ9"},{av:"AV7cTripsDate",fld:"vCTRIPSDATE",pic:""}],[]];this.EvtParms.GRID1_PREVPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripsId",fld:"vCTRIPSID",pic:"ZZZ9"},{av:"AV7cTripsDate",fld:"vCTRIPSDATE",pic:""}],[]];this.EvtParms.GRID1_NEXTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripsId",fld:"vCTRIPSID",pic:"ZZZ9"},{av:"AV7cTripsDate",fld:"vCTRIPSDATE",pic:""}],[]];this.EvtParms.GRID1_LASTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripsId",fld:"vCTRIPSID",pic:"ZZZ9"},{av:"AV7cTripsDate",fld:"vCTRIPSDATE",pic:""}],[]];this.setVCMap("AV8pTripsId","vPTRIPSID",0,"int",4,0);t.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid1"});t.addRefreshingVar(this.GXValidFnc[16]);t.addRefreshingVar(this.GXValidFnc[26]);t.addRefreshingParm(this.GXValidFnc[16]);t.addRefreshingParm(this.GXValidFnc[26]);this.Initialize()});gx.wi(function(){gx.createParentObj(this.gx00f0)})