/**
 * 老人的数目
 * @param {string[]} details
 * @return {number}
 */
let countSeniors = function (details) {
    return details.filter(x => x.slice(-4, -2) > 60).length;
};