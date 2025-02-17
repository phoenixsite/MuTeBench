/***************************************************************************
 *  Copyright (C) 2010 by H-Store Project                                  *
 *  Brown University                                                       *
 *  Massachusetts Institute of Technology                                  *
 *  Yale University                                                        *
 *                                                                         *
 *  Andy Pavlo (pavlo@cs.brown.edu)                                        *
 *  http://www.cs.brown.edu/~pavlo/                                        *
 *                                                                         *
 *  Visawee Angkanawaraphan (visawee@cs.brown.edu)                         *
 *  http://www.cs.brown.edu/~visawee/                                      *
 *                                                                         *
 *  Permission is hereby granted, free of charge, to any person obtaining  *
 *  a copy of this software and associated documentation files (the        *
 *  "Software"), to deal in the Software without restriction, including    *
 *  without limitation the rights to use, copy, modify, merge, publish,    *
 *  distribute, sublicense, and/or sell copies of the Software, and to     *
 *  permit persons to whom the Software is furnished to do so, subject to  *
 *  the following conditions:                                              *
 *                                                                         *
 *  The above copyright notice and this permission notice shall be         *
 *  included in all copies or substantial portions of the Software.        *
 *                                                                         *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,        *
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF     *
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. *
 *  IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR      *
 *  OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,  *
 *  ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR  *
 *  OTHER DEALINGS IN THE SOFTWARE.                                        *
 ***************************************************************************/
package com.oltpbenchmark.benchmarks.auctionmark;

import java.util.*;

import com.oltpbenchmark.util.StringUtil;

public abstract class AuctionMarkConstants {

	// ----------------------------------------------------------------
	// TIME PARAMETERS
	// ----------------------------------------------------------------

	public static final long SECONDS_IN_A_DAY = 24 * 60 * 60;
	public static final long MILLISECONDS_IN_A_SECOND = 1000;
	public static final long MILLISECONDS_IN_A_DAY = SECONDS_IN_A_DAY
			* MILLISECONDS_IN_A_SECOND;

	/**
	 * 1 sec in real time equals this value in the benchmark's virtual time in
	 * seconds
	 */
	public static final long TIME_SCALE_FACTOR = 600l; // one hour

	/**
	 * If the amount of time in seconds remaining for an item auction is less
	 * than this parameter, then it will be added to a special queue in the
	 * client. We will increase the likelihood that a users will bid on these
	 * items as it gets closer to their end times
	 */
	public static final long ITEM_ENDING_SOON = 36000l; // 10 hours

	public static final int ITEM_ALREADY_ENDED = 100000;

	// ----------------------------------------------------------------
	// EXECUTION CONFIGURATION
	// ----------------------------------------------------------------

	public static boolean CLOSE_AUCTIONS_ENABLE = false;

	/**
	 * How often to execute CLOSE_AUCTIONS in virtual seconds
	 * 
	 * @see AuctionMarkConstants.TIME_SCALE_FACTOR
	 */
	public static final long CLOSE_AUCTIONS_INTERVAL = 12000l; // Every 20
																// seconds

	/**
	 * If set to true, the CloseAuctions transactions will be a executed in a
	 * separate thread. If set to false, then these txns will be executed
	 * whenever the interval interrupt occurs on the first worker thread
	 */
	public static boolean CLOSE_AUCTIONS_SEPARATE_THREAD = false;

	/**
	 * If set to true, then the first client will attempt to reset the database
	 * before starting the benchmark execution
	 */
	public static final boolean RESET_DATABASE_ENABLE = false;

	// ----------------------------------------------------------------
	// STORED PROCEDURE INFORMATION
	// ----------------------------------------------------------------

	// Non-standard txns
	public static final int FREQUENCY_CLOSE_AUCTIONS = -1; // called at regular
															// intervals

	// Regular Txn Mix
	public static final int FREQUENCY_GET_ITEM = 25;
	public static final int FREQUENCY_GET_USER_INFO = 15;
	public static final int FREQUENCY_NEW_BID = 20;
	public static final int FREQUENCY_NEW_COMMENT = 5;
	public static final int FREQUENCY_NEW_COMMENT_RESPONSE = 5;
	public static final int FREQUENCY_NEW_FEEDBACK = 5;
	public static final int FREQUENCY_NEW_ITEM = 10;
	public static final int FREQUENCY_NEW_PURCHASE = 5;
	public static final int FREQUENCY_UPDATE_ITEM = 10;

	// ----------------------------------------------------------------
	// DEFAULT TABLE SIZES
	// ----------------------------------------------------------------

	public static final long TABLESIZE_REGION = 75;
	public static final long TABLESIZE_GLOBAL_ATTRIBUTE_GROUP = 100;
	public static final long TABLESIZE_GLOBAL_ATTRIBUTE_VALUE = 1; // HACK:
																	// IGNORE
	public static final long TABLESIZE_GLOBAL_ATTRIBUTE_VALUE_PER_GROUP = 10;
	public static final long TABLESIZE_USERACCT = 10000;

	// ----------------------------------------------------------------
	// USER PARAMETERS
	// ----------------------------------------------------------------

	public static final int USER_MIN_ATTRIBUTES = 0;
	public static final int USER_MAX_ATTRIBUTES = 5;

	public static final long USER_MIN_BALANCE = 1000;
	public static final long USER_MAX_BALANCE = 100000;

	public static final long USER_MIN_RATING = 0;
	public static final long USER_MAX_RATING = 10000;

	public static final int USER_ATTRIBUTE_NAME_LENGTH_MIN = 5;
	public static final int USER_ATTRIBUTE_NAME_LENGTH_MAX = 32;

	public static final int USER_ATTRIBUTE_VALUE_LENGTH_MIN = 5;
	public static final int USER_ATTRIBUTE_VALUE_LENGTH_MAX = 32;

	// ----------------------------------------------------------------
	// ITEM PARAMETERS
	// ----------------------------------------------------------------

	public static final int ITEM_INITIAL_PRICE_MIN = 1;
	public static final int ITEM_INITIAL_PRICE_MAX = 1000;
	public static final double ITEM_INITIAL_PRICE_SIGMA = 1.25;

	public static final int ITEM_ITEMS_PER_SELLER_MIN = 0;
	public static final int ITEM_ITEMS_PER_SELLER_MAX = 1000;
	public static final double ITEM_ITEMS_PER_SELLER_SIGMA = 2.0;

	public static final int ITEM_BIDS_PER_DAY_MIN = 0;
	public static final int ITEM_BIDS_PER_DAY_MAX = 10;
	public static final double ITEM_BIDS_PER_DAY_SIGMA = 1.25;

	public static final int ITEM_WATCHES_PER_DAY_MIN = 0;
	public static final int ITEM_WATCHES_PER_DAY_MAX = 5;
	public static final double ITEM_WATCHES_PER_DAY_SIGMA = 1.25;

	public static final int ITEM_NUM_IMAGES_MIN = 1;
	public static final int ITEM_NUM_IMAGES_MAX = 10;
	public static final double ITEM_NUM_IMAGES_SIGMA = 1.25;

	public static final int ITEM_NUM_COMMENTS_MIN = 0;
	public static final int ITEM_NUM_COMMENTS_MAX = 5;
	public static final double ITEM_NUM_COMMENTS_SIGMA = 1.25;

	public static final int ITEM_COMMENT_LENGTH_MIN = 10;
	public static final int ITEM_COMMENT_LENGTH_MAX = 128;

	public static final int ITEM_NUM_GLOBAL_ATTRS_MIN = 1;
	public static final int ITEM_NUM_GLOBAL_ATTRS_MAX = 10;
	public static final double ITEM_NUM_GLOBAL_ATTRS_SIGMA = 1.25;

	public static final int ITEM_NAME_LENGTH_MIN = 16;
	public static final int ITEM_NAME_LENGTH_MAX = 100;

	public static final int ITEM_DESCRIPTION_LENGTH_MIN = 50;
	public static final int ITEM_DESCRIPTION_LENGTH_MAX = 255;

	public static final int ITEM_USER_ATTRIBUTES_LENGTH_MIN = 20;
	public static final int ITEM_USER_ATTRIBUTES_LENGTH_MAX = 255;

	/**
	 * When an item receives a bid we will increase its price by this amount
	 */
	public static final float ITEM_BID_PERCENT_STEP = 0.025f;

	/**
	 * How long should we wait before the buyer purchases an item that they won
	 */
	public static final int ITEM_PURCHASE_DURATION_DAYS_MIN = 0;
	public static final int ITEM_PURCHASE_DURATION_DAYS_MAX = 7;
	public static final double ITEM_PURCHASE_DURATION_DAYS_SIGMA = 1.1;

	/**
	 * Duration in days that expired bids are preserved
	 */
	public static final int ITEM_PRESERVE_DAYS = 7;

	/**
	 * The duration in days for each auction
	 */
	public static final int ITEM_DURATION_DAYS_MIN = 1;
	public static final int ITEM_DURATION_DAYS_MAX = 10;

	/**
	 * This defines the number of items to read in when LoadConfig is invoked
	 */
	public static final int ITEM_LOADCONFIG_LIMIT = 5000;

	/**
	 * This defines the maximum size of a small cache of ItemIds that we
	 * maintain in the benchmark profile. For some procedures, the client will
	 * ItemIds out of this cache and use them as txn parameters
	 */
	public static final int ITEM_ID_CACHE_SIZE = 1000;

	/**
	 * The number of update rounds in each invocation of CloseAuctions
	 */
	public static final int CLOSE_AUCTIONS_ROUNDS = 1;

	/**
	 * The number of items to pull in for each update round in CloseAuctions
	 */
	public static final int CLOSE_AUCTIONS_ITEMS_PER_ROUND = 100;

	/**
	 * The default list of columns that we will return whenever we query the
	 * item table. This must match the ordering expected in
	 * AuctionMarkWorker.processItemRecord()
	 */
	public static final String ITEM_COLUMNS[] = { "i_id", "i_u_id", "i_name",
			"i_current_price", "i_num_bids", "i_end_date", "i_status" };
	public static final String ITEM_COLUMNS_STR = StringUtil.join(", ",
			ITEM_COLUMNS);

	// ----------------------------------------------------------------
	// DEFAULT BATCH SIZES
	// ----------------------------------------------------------------

	public static final long BATCHSIZE_REGION = 5000;
	public static final long BATCHSIZE_GLOBAL_ATTRIBUTE_GROUP = 5000;
	public static final long BATCHSIZE_GLOBAL_ATTRIBUTE_VALUE = 5000;
	public static final long BATCHSIZE_CATEGORY = 5000;
	public static final long BATCHSIZE_USERACCT = 1000;
	public static final long BATCHSIZE_USERACCT_ATTRIBUTES = 5000;
	public static final long BATCHSIZE_USERACCT_FEEDBACK = 5000;
	public static final long BATCHSIZE_USERACCT_ITEM = 5000;
	public static final long BATCHSIZE_USERACCT_WATCH = 5000;
	public static final long BATCHSIZE_ITEM = 2000;
	public static final long BATCHSIZE_ITEM_ATTRIBUTE = 5000;
	public static final long BATCHSIZE_ITEM_IMAGE = 5000;
	public static final long BATCHSIZE_ITEM_COMMENT = 1000;
	public static final long BATCHSIZE_ITEM_BID = 5000;
	public static final long BATCHSIZE_ITEM_MAX_BID = 5000;
	public static final long BATCHSIZE_ITEM_PURCHASE = 5000;

	// ----------------------------------------------------------------
	// TABLE NAMES
	// ----------------------------------------------------------------
	public static final String TABLENAME_CONFIG_PROFILE = "CONFIG_PROFILE";
	public static final String TABLENAME_REGION = "REGION";
	public static final String TABLENAME_USERACCT = "USERACCT";
	public static final String TABLENAME_USERACCT_ATTRIBUTES = "USERACCT_ATTRIBUTES";
	public static final String TABLENAME_USERACCT_ITEM = "USERACCT_ITEM";
	public static final String TABLENAME_USERACCT_WATCH = "USERACCT_WATCH";
	public static final String TABLENAME_USERACCT_FEEDBACK = "USERACCT_FEEDBACK";
	public static final String TABLENAME_CATEGORY = "CATEGORY";
	public static final String TABLENAME_GLOBAL_ATTRIBUTE_GROUP = "GLOBAL_ATTRIBUTE_GROUP";
	public static final String TABLENAME_GLOBAL_ATTRIBUTE_VALUE = "GLOBAL_ATTRIBUTE_VALUE";
	public static final String TABLENAME_ITEM = "ITEM";
	public static final String TABLENAME_ITEM_ATTRIBUTE = "ITEM_ATTRIBUTE";
	public static final String TABLENAME_ITEM_IMAGE = "ITEM_IMAGE";
	public static final String TABLENAME_ITEM_COMMENT = "ITEM_COMMENT";
	public static final String TABLENAME_ITEM_BID = "ITEM_BID";
	public static final String TABLENAME_ITEM_MAX_BID = "ITEM_MAX_BID";
	public static final String TABLENAME_ITEM_PURCHASE = "ITEM_PURCHASE";

	public static final String TABLENAMES[] = {
			AuctionMarkConstants.TABLENAME_REGION,
			AuctionMarkConstants.TABLENAME_CATEGORY,
			AuctionMarkConstants.TABLENAME_GLOBAL_ATTRIBUTE_GROUP,
			AuctionMarkConstants.TABLENAME_GLOBAL_ATTRIBUTE_VALUE,
			AuctionMarkConstants.TABLENAME_USERACCT,
			AuctionMarkConstants.TABLENAME_USERACCT_ATTRIBUTES,
			AuctionMarkConstants.TABLENAME_USERACCT_ITEM,
			AuctionMarkConstants.TABLENAME_USERACCT_WATCH,
			AuctionMarkConstants.TABLENAME_USERACCT_FEEDBACK,
			AuctionMarkConstants.TABLENAME_ITEM,
			AuctionMarkConstants.TABLENAME_ITEM_ATTRIBUTE,
			AuctionMarkConstants.TABLENAME_ITEM_IMAGE,
			AuctionMarkConstants.TABLENAME_ITEM_COMMENT,
			AuctionMarkConstants.TABLENAME_ITEM_BID,
			AuctionMarkConstants.TABLENAME_ITEM_MAX_BID,
			AuctionMarkConstants.TABLENAME_ITEM_PURCHASE, };

	// ----------------------------------------------------------------
	// TABLE DATA SOURCES
	// ----------------------------------------------------------------

	// If a table exists in this set, then the number of tuples loaded into the
	// table
	// should not be modified by the scale factor
	public static final Collection<String> FIXED_TABLES = new HashSet<String>();
	static {
		FIXED_TABLES.add(AuctionMarkConstants.TABLENAME_REGION);
		FIXED_TABLES.add(AuctionMarkConstants.TABLENAME_GLOBAL_ATTRIBUTE_GROUP);
		FIXED_TABLES.add(AuctionMarkConstants.TABLENAME_GLOBAL_ATTRIBUTE_VALUE);
	}

	public static final Collection<String> DYNAMIC_TABLES = new HashSet<String>();
	static {
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_USERACCT_ATTRIBUTES);
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_IMAGE);
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_ATTRIBUTE);
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_COMMENT);
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_USERACCT_FEEDBACK);
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_BID);
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_MAX_BID);
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_PURCHASE);
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_USERACCT_ITEM);
		DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_USERACCT_WATCH);
	}

	// These tables are loaded from static data files
	public static final Collection<String> DATAFILE_TABLES = new HashSet<String>();
	static {
		DATAFILE_TABLES.add(AuctionMarkConstants.TABLENAME_CATEGORY);
	}

	// ----------------------------------------------------------------
	// PROBABILITIES
	// ----------------------------------------------------------------

	/** The probability that a buyer will leave feedback for the seller (1-100) */
	public static final int PROB_PURCHASE_BUYER_LEAVES_FEEDBACK = 75;
	/** The probability that a seller will leave feedback for the buyer (1-100) */
	public static final int PROB_PURCHASE_SELLER_LEAVES_FEEDBACK = 80;

	public static final int PROB_GETUSERINFO_INCLUDE_FEEDBACK = 25;
	public static final int PROB_GETUSERINFO_INCLUDE_COMMENTS = 10;
	public static final int PROB_GETUSERINFO_INCLUDE_SELLER_ITEMS = 10;
	public static final int PROB_GETUSERINFO_INCLUDE_BUYER_ITEMS = 10;
	public static final int PROB_GETUSERINFO_INCLUDE_WATCHED_ITEMS = 10;

	public static final int PROB_UPDATEITEM_DELETE_ATTRIBUTE = 25;
	public static final int PROB_UPDATEITEM_ADD_ATTRIBUTE = -1; // 25;

	/**
	 * The probability that a buyer will not have enough money to purchase an
	 * item (1-100)
	 */
	public static final int PROB_NEWPURCHASE_NOT_ENOUGH_MONEY = 1;

	/**
	 * The probability that the NewBid txn will try to bid on a closed item
	 * (1-100)
	 */
	public static final int PROB_NEWBID_CLOSED_ITEM = 5;

	/**
	 * The probability that a NewBid txn will target an item whose auction is
	 * ending soon (1-100)
	 */
	public static final int PROB_NEWBID_ENDINGSOON_ITEM = 50;

}
