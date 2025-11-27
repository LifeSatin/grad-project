export async function load({ fetch, params, cookies }) {
    const token = cookies.get('token') ?? null;

	const res = await fetch(`http://3.27.115.22:8080/member?token=${token}`);
    const item = await res.json();
    console.log(item);

    const comres = await fetch(`http://3.27.115.22:8080/member/comments?memberId=${item.id}`)
    console.log("comres");
    console.log(comres);
    const comlist = await comres.json();
    console.log("comlist");
    console.log(comlist);

    return { item, comlist };
}