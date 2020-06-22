package com.kitri.pos;

public class PosDto {

	// ÇÊµå Œ±Ÿð

	private int USER_CODE; // À¯ÀúÄÚµå
	private String name; // ÀÌž§
	private String attendCode; // Ãâ°áÄÚµå
	private String loginTime; // Ãâ±ÙœÃ°£
	private String logoutTime; // Åð±ÙœÃ°£
	private String workTime; // ±Ù¹«œÃ°£
	private String pw; // ÆÐœº¿öµå
	private String id; // ŸÆÀÌµð
	private String authority; // ±ÇÇÑ
	// ===================================//
	private String cooperateName; // ÁŠÈÞ»ç
	private String company; // ÁŠÁ¶»ç
	private String productCode; // »óÇ°ÄÚµå
	private String productName; // »óÇ°ÀÌž§
	private String levelCode; // ºÐ·ùÄÚµå
	private String majorLevel; // ŽëºÐ·ù
	private String mediumLevel; // ÁßºÐ·ù
	private String minorLevel; // ŒÒºÐ·ù
	private int price; // °¡°Ý
	private int purchase; // žÅÀÔ°¡
	private int volume; // Œö·®
	private String realExp; // À¯Åë±âÇÑ
	// ===================================//
	private String sellId; // ÆÇžÅŸÆÀÌµð
	private String sellDate; // ÆÇžÅÀÏÀÚ
	private int sellCount; // ÆÇžÅŒö·®
	private String countDate; // Á€»ê³¯Â¥
	private int comsCalc; // Çö±Ý°áÁŠ±ÝŸ×
	private int cashPrice;
	private String discountPct; // ÇÒÀÎÀ²
	private int currentMoney; // ÇöÀçœÃÁŠ
	private int totalCalc; // Â÷Ÿ×
	private String phone; // ÇÚµåÆù¹øÈ£
	private int point; // Æ÷ÀÎÆ®
	private String payment;
	private int cardPrice; // Ä«µå°áÁŠ±ÝŸ×
	private String inDate; // ÀÔ°í³¯Â¥
	private int totalPrice;
	private String discountCode; // ÇÒÀÎÄÚµå
	private String membershipId; // žÉ¹öœ±ŸÆÀÌµð
	// =====================================//
	private int ranking;           // žÅÃâŒøÀ§
	private int statTotalPrice;   // žÅÃâÇÕ°è
	private int totalTax;           // ºÎ°¡ŒŒÇÕ°è
	private int customerCount; // °í°ŽŒö

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getStatTotalPrice() {
		return statTotalPrice;
	}

	public void setStatTotalPrice(int statTotalPrice) {
		this.statTotalPrice = statTotalPrice;
	}

	public int getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(int totalTax) {
		this.totalTax = totalTax;
	}

	public int getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserCode() {
		return USER_CODE;
	}

	public void setUserCode(int USER_CODE) {
		this.USER_CODE = USER_CODE;
	}

	public String getAttendCode() {
		return attendCode;
	}

	public void setAttendCode(String attendCode) {
		this.attendCode = attendCode;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getCooperateName() {
		return cooperateName;
	}

	public void setCooperateName(String cooperateName) {
		this.cooperateName = cooperateName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getMajorLevel() {
		return majorLevel;
	}

	public void setMajorLevel(String majorLevel) {
		this.majorLevel = majorLevel;
	}

	public String getMediumLevel() {
		return mediumLevel;
	}

	public void setMediumLevel(String mediumLevel) {
		this.mediumLevel = mediumLevel;
	}

	public String getMinorLevel() {
		return minorLevel;
	}

	public void setMinorLevel(String minorLevel) {
		this.minorLevel = minorLevel;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPurchase() {
		return purchase;
	}

	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getRealExp() {
		return realExp;
	}

	public void setRealExp(String realExp) {
		this.realExp = realExp;
	}

	public String getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}

	public String getSellId() {
		return sellId;
	}

	public void setSellId(String sellId) {
		this.sellId = sellId;
	}

	public String getSellDate() {
		return sellDate;
	}

	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}

	public int getSellCount() {
		return sellCount;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}

	public String getCountDate() {
		return countDate;
	}

	public void setCountDate(String countDate) {
		this.countDate = countDate;
	}

	public int getComsCalc() {
		return comsCalc;
	}

	public void setComsCalc(int comsCalc) {
		this.comsCalc = comsCalc;
	}

	public int getCashPrice() {
		return cashPrice;
	}

	public void setCashPrice(int cashPrice) {
		this.cashPrice = cashPrice;
	}

	public String getDiscountPct() {
		return discountPct;
	}

	public void setDiscountPct(String discountPct) {
		this.discountPct = discountPct;
	}

	public int getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}

	public int getTotalCalc() {
		return totalCalc;
	}

	public void setTotalCalc(int totalCalc) {
		this.totalCalc = totalCalc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getCardPrice() {
		return cardPrice;
	}

	public void setCardPrice(int cardPrice) {
		this.cardPrice = cardPrice;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getExpName() {
		// TODO Auto-generated method stub
		return realExp;
	}

	public int getListNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}