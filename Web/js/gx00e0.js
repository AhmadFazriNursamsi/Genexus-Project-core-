gx.evt.autoSkip=!1;gx.define("gx00e0",!1,function(){var n,t;this.ServerClass="gx00e0";this.PackageName="com.kbbaru";this.ServerFullClass="com.kbbaru.gx00e0";this.setObjectType("web");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="KBBaru";this.SetStandaloneVars=function(){this.AV8pTripId=gx.fn.getIntegerValue("vPTRIPID",",")};this.e13201_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class"),"AdvancedContainer")==0?(gx.fn.setCtrlProperty("ADVANCEDCONTAINER","Class","AdvancedContainer AdvancedContainerVisible"),gx.fn.setCtrlProperty("BTNTOGGLE","Class",gx.fn.getCtrlProperty("BTNTOGGLE","Class")+" BtnToggleActive")):(gx.fn.setCtrlProperty("ADVANCEDCONTAINER","Class","AdvancedContainer"),gx.fn.setCtrlProperty("BTNTOGGLE","Class","BtnToggle")),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e11201_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TRIPIDFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("TRIPIDFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCTRIPID","Visible",!0)):(gx.fn.setCtrlProperty("TRIPIDFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCTRIPID","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TRIPIDFILTERCONTAINER","Class")',ctrl:"TRIPIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTRIPID","Visible")',ctrl:"vCTRIPID",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12201_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TRIPDATEFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?gx.fn.setCtrlProperty("TRIPDATEFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"):gx.fn.setCtrlProperty("TRIPDATEFILTERCONTAINER","Class","AdvancedContainerItem"),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TRIPDATEFILTERCONTAINER","Class")',ctrl:"TRIPDATEFILTERCONTAINER",prop:"Class"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16202_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e17201_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,35,36,37,38,39,40];this.GXLastCtrlId=40;this.Grid1Container=new gx.grid.grid(this,2,"WbpLvl2",34,"Grid1","Grid1","Grid1Container",this.CmpContext,this.IsMasterPage,"gx00e0",[],!1,1,!1,!0,10,!0,!1,!1,"",0,"px",0,"px","New row",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.Grid1Container;t.addBitmap("&Linkselection","vLINKSELECTION",35,0,"px",17,"px",null,"","","SelectionAttribute","WWActionColumn");t.addSingleLineEdit(18,36,"TRIPID","Id","","TripId","int",0,"px",4,4,"right",null,[],18,"TripId",!0,0,!1,!1,"Attribute",0,"WWColumn");t.addSingleLineEdit(19,37,"TRIPDATE","Date","","TripDate","date",0,"px",8,8,"right",null,[],19,"TripDate",!0,0,!1,!1,"DescriptionAttribute",0,"WWColumn");this.Grid1Container.emptyText="";this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAIN",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"ADVANCEDCONTAINER",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TRIPIDFILTERCONTAINER",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"LBLTRIPIDFILTER",format:1,grid:0,evt:"e11201_client",ctrltype:"textblock"};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"",grid:0};n[16]={id:16,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTRIPID",fmt:0,gxz:"ZV6cTripId",gxold:"OV6cTripId",gxvar:"AV6cTripId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV6cTripId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV6cTripId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCTRIPID",gx.O.AV6cTripId,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV6cTripId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCTRIPID",",")},nac:gx.falseFn};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"TRIPDATEFILTERCONTAINER",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"LBLTRIPDATEFILTER",format:1,grid:0,evt:"e12201_client",ctrltype:"textblock"};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTRIPDATE",fmt:0,gxz:"ZV7cTripDate",gxold:"OV7cTripDate",gxvar:"AV7cTripDate",dp:{f:-1,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV7cTripDate=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV7cTripDate=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("vCTRIPDATE",gx.O.AV7cTripDate,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV7cTripDate=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("vCTRIPDATE")},nac:gx.falseFn};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"GRIDTABLE",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"BTNTOGGLE",grid:0,evt:"e13201_client"};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[35]={id:35,lvl:2,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:34,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vLINKSELECTION",fmt:0,gxz:"ZV5LinkSelection",gxold:"OV5LinkSelection",gxvar:"AV5LinkSelection",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV5LinkSelection=n)},v2z:function(n){n!==undefined&&(gx.O.ZV5LinkSelection=n)},v2c:function(n){gx.fn.setGridMultimediaValue("vLINKSELECTION",n||gx.fn.currentGridRowImpl(34),gx.O.AV5LinkSelection,gx.O.AV12Linkselection_GXI)},c2v:function(n){gx.O.AV12Linkselection_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.AV5LinkSelection=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vLINKSELECTION",n||gx.fn.currentGridRowImpl(34))},val_GXI:function(n){return gx.fn.getGridControlValue("vLINKSELECTION_GXI",n||gx.fn.currentGridRowImpl(34))},gxvar_GXI:"AV12Linkselection_GXI",nac:gx.falseFn};n[36]={id:36,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:34,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRIPID",fmt:0,gxz:"Z18TripId",gxold:"O18TripId",gxvar:"A18TripId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A18TripId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z18TripId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("TRIPID",n||gx.fn.currentGridRowImpl(34),gx.O.A18TripId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A18TripId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("TRIPID",n||gx.fn.currentGridRowImpl(34),",")},nac:gx.falseFn};n[37]={id:37,lvl:2,type:"date",len:8,dec:0,sign:!1,ro:1,isacc:0,grid:34,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRIPDATE",fmt:0,gxz:"Z19TripDate",gxold:"O19TripDate",gxvar:"A19TripDate",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A19TripDate=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z19TripDate=gx.fn.toDatetimeValue(n))},v2c:function(n){gx.fn.setGridControlValue("TRIPDATE",n||gx.fn.currentGridRowImpl(34),gx.O.A19TripDate,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A19TripDate=gx.fn.toDatetimeValue(this.val(n)))},val:function(n){return gx.fn.getGridDateTimeValue("TRIPDATE",n||gx.fn.currentGridRowImpl(34))},nac:gx.falseFn};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"BTN_CANCEL",grid:0,evt:"e17201_client"};this.AV6cTripId=0;this.ZV6cTripId=0;this.OV6cTripId=0;this.AV7cTripDate=gx.date.nullDate();this.ZV7cTripDate=gx.date.nullDate();this.OV7cTripDate=gx.date.nullDate();this.ZV5LinkSelection="";this.OV5LinkSelection="";this.Z18TripId=0;this.O18TripId=0;this.Z19TripDate=gx.date.nullDate();this.O19TripDate=gx.date.nullDate();this.AV6cTripId=0;this.AV7cTripDate=gx.date.nullDate();this.AV8pTripId=0;this.AV5LinkSelection="";this.A18TripId=0;this.A19TripDate=gx.date.nullDate();this.Events={e16202_client:["ENTER",!0],e17201_client:["CANCEL",!0],e13201_client:["'TOGGLE'",!1],e11201_client:["LBLTRIPIDFILTER.CLICK",!1],e12201_client:["LBLTRIPDATEFILTER.CLICK",!1]};this.EvtParms.REFRESH=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripId",fld:"vCTRIPID",pic:"ZZZ9"},{av:"AV7cTripDate",fld:"vCTRIPDATE",pic:""}],[]];this.EvtParms["'TOGGLE'"]=[[{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}]];this.EvtParms["LBLTRIPIDFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TRIPIDFILTERCONTAINER","Class")',ctrl:"TRIPIDFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TRIPIDFILTERCONTAINER","Class")',ctrl:"TRIPIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTRIPID","Visible")',ctrl:"vCTRIPID",prop:"Visible"}]];this.EvtParms["LBLTRIPDATEFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TRIPDATEFILTERCONTAINER","Class")',ctrl:"TRIPDATEFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TRIPDATEFILTERCONTAINER","Class")',ctrl:"TRIPDATEFILTERCONTAINER",prop:"Class"}]];this.EvtParms.ENTER=[[{av:"A18TripId",fld:"TRIPID",pic:"ZZZ9",hsh:!0}],[{av:"AV8pTripId",fld:"vPTRIPID",pic:"ZZZ9"}]];this.EvtParms.GRID1_FIRSTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripId",fld:"vCTRIPID",pic:"ZZZ9"},{av:"AV7cTripDate",fld:"vCTRIPDATE",pic:""}],[]];this.EvtParms.GRID1_PREVPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripId",fld:"vCTRIPID",pic:"ZZZ9"},{av:"AV7cTripDate",fld:"vCTRIPDATE",pic:""}],[]];this.EvtParms.GRID1_NEXTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripId",fld:"vCTRIPID",pic:"ZZZ9"},{av:"AV7cTripDate",fld:"vCTRIPDATE",pic:""}],[]];this.EvtParms.GRID1_LASTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTripId",fld:"vCTRIPID",pic:"ZZZ9"},{av:"AV7cTripDate",fld:"vCTRIPDATE",pic:""}],[]];this.setVCMap("AV8pTripId","vPTRIPID",0,"int",4,0);t.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid1"});t.addRefreshingVar(this.GXValidFnc[16]);t.addRefreshingVar(this.GXValidFnc[26]);t.addRefreshingParm(this.GXValidFnc[16]);t.addRefreshingParm(this.GXValidFnc[26]);this.Initialize()});gx.wi(function(){gx.createParentObj(this.gx00e0)})